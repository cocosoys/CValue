# ReCValue

[中文](README.md) | [English](README_EN.md)

## 简介

`ReCValue` 是围绕 Dragon Block C / JRMCore 的数值读取与辅助封装库。

它的目标不是替代 JRMCore，而是把旧版中分散在 `Base`、`Util`、`Player` 等类里的常见读取逻辑收敛为统一、稳定、便于调用的门面 API，方便其他开发者直接获取：

- 等级、属性、气血体等基础数值
- 技能、槽位、属性加成、玩家设置位
- 形态、Mastery、状态效果、当前战斗状态
- 任务、剧情、小队、融合等运行时数据
- 各个种族特有的数值与形态偏好

为保持现有调用兼容性，公开 API 命名当前仍然保留 `CValueAPI`、`CValueAPIStats`、`CValueAttribute` 等前缀。

当前源码侧推荐入口是 [`src/com/cvalue/api/CValueAPI.java`](src/com/recvalue/api/CValueAPI.java)。

## 适用环境

- Minecraft / Forge 1.7.10
- Dragon Block C + JRMCore
- Java 8
- 当前主要面向 `net.minecraft.entity.player.EntityPlayer`

如果你需要的是 Bukkit 侧桥接能力，请先确认你的运行时是否真的具备与 DBC/JRMCore 兼容的混合对象模型；当前 `src` 下这套 API 本质上仍然是基于模组侧 `EntityPlayer` 的封装。

## API 结构

目前 API 已按职责拆分为以下几组，主入口统一由 `CValueAPI` 提供：

- [`CValueAPI`](src/com/recvalue/api/CValueAPI.java)：总入口，负责返回玩家绑定实例和分组实例
- [`CValueAPIBase`](src/com/recvalue/api/CValueAPIBase.java)：基础入口、种族访问、全局 helper、底层视图访问
- [`CValueAPIStats`](src/com/recvalue/api/CValueAPIStats.java)：等级、属性、血气体、战斗数值、百分比、基础派生值
- [`CValueAPISkills`](src/com/recvalue/api/CValueAPISkills.java)：技能、技能槽、已学技能、属性 bonus、玩家设置位
- [`CValueAPIForms`](src/com/recvalue/api/CValueAPIForms.java)：形态、Mastery、状态效果、阵营、外观、运行时状态
- [`CValueAPITasks`](src/com/recvalue/api/CValueAPITasks.java)：任务、剧情、小队、融合、部分剧情运行时数据

辅助枚举与类型：

- [`CValueAttribute`](src/com/recvalue/api/CValueAttribute.java)：属性枚举，避免手写 `0~5`
- [`CValueStatusEffect`](src/com/recvalue/api/CValueStatusEffect.java)：常用状态效果枚举
- [`CValuePlayerSetting`](src/com/recvalue/api/CValuePlayerSetting.java)：玩家设置位枚举
- [`CValueTaskType`](src/com/recvalue/api/CValueTaskType.java)：任务类型枚举

底层 race 实现位于：

- [`src/com/cvalue/base/race`](src/com/recvalue/base/race)

## 推荐用法

### 1. 直接静态调用

适合只读取 1 到 2 个值的场景。

```java
import com.recvalue.api.CValueAPI;
import com.recvalue.api.CValueAttribute;
import com.recvalue.api.CValueStatusEffect;
import net.minecraft.entity.player.EntityPlayer;

EntityPlayer player = ...;

int level = CValueAPI.getLevel(player);
int maxKi = CValueAPI.getMaxKi(player);
int maxBody = CValueAPI.getMaxBody(player);
double raceMastery = CValueAPI.getRaceFormMastery(player);

int strength = CValueAPI.getAttribute(player, CValueAttribute.STRENGTH);
boolean kaioken = CValueAPI.hasStatusEffect(player, CValueStatusEffect.KAIOKEN);
```

### 2. 先绑定玩家，再连续读取

适合同一个玩家要连续读取多项数据的场景。

```java
import com.recvalue.api.CValueAPI;

CValueAPI api = CValueAPI.of(player);

int level = api.getLevel();
int maxKi = api.getMaxKi();
int melee = api.getMelee();
int currentBody = api.getCurrentBody();
String currentForm = api.getCurrentFormName();
String missionSync = api.getMissionSyncData();
```

### 3. 按分组调用，提升可读性

如果你希望代码更容易维护，可以显式走分组实例：

```java
CValueAPI api = CValueAPI.of(player);

int maxKi = api.stats().getMaxKi();
int running = api.stats().getRunning();

int mysticLevel = api.skills().getMysticSkillLevel();
String[] learnedSkills = api.skills().getLearnedSkills();

String formName = api.forms().getCurrentFormName();
boolean uiActive = api.forms().isUltraInstinctActive();

String[] taskTypes = api.tasks().getTaskTypes();
boolean hasMainDbcTask = api.tasks().hasTaskType(CValueTaskType.MAIN_DBC);
```

### 4. 使用枚举，避免魔法值

```java
int strength = CValueAPI.getAttribute(player, CValueAttribute.STRENGTH);
boolean kaioken = CValueAPI.hasStatusEffect(player, CValueStatusEffect.KAIOKEN);

int kaiokenSetting = CValueAPI.getPlayerSettingValue(player, CValuePlayerSetting.KAIOKEN);
boolean hasMainDbcTask = CValueAPI.hasTaskType(player, CValueTaskType.MAIN_DBC);
```

## 种族专属 API

针对不同种族，项目已经把部分仅该种族有意义的数值放到了对应 race 类中，避免全部堆在通用门面里。

### 赛亚人

```java
int saiyanMeter = CValueAPI.saiyan(player).getSaiyanTransformationMeter();
boolean godRoute = CValueAPI.saiyan(player).isSaiyanTransformTypeGodSelected();
String preferredForm = CValueAPI.saiyan(player).getPreferredSaiyanTransformationFormName();
```

### 冰冻恶魔族

```java
int reserve = CValueAPI.arcosian(player).getPowerPointReserve();
int transformMode = CValueAPI.arcosian(player).getArcosianTransformTypeMode();
String preferredForm = CValueAPI.arcosian(player).getPreferredArcosianTransformationFormName();
```

### 魔人

```java
int absorption = CValueAPI.majin(player).getAbsorptionValue();
int absorptionTimer = CValueAPI.majin(player).getAbsorptionTimer();
String preferredForm = CValueAPI.majin(player).getPreferredMajinTransformationFormName();
```

同样地，你也可以使用：

- `CValueAPI.human(player)`
- `CValueAPI.halfSaiyan(player)`
- `CValueAPI.namekian(player)`

来访问对应种族类中的专属方法。

## 当前已覆盖的数据类型

当前 facade 已经覆盖的主要数据类型包括：

- 基础数值：等级、属性、最大气、最大血量、最大体力、近战、气功、跑速、飞行
- 当前数值：当前血量、当前气、当前体力、百分比、释放率、状态值
- 技能与成长：技能等级、技能槽、已学技能、训练点、属性点、经验、Gravity Training
- 形态与状态：当前形态、Mastery、状态效果、UI Heat、God Strain、Pain Timer、Transformation Meter
- 阵营与统计：Alignment、Karma、击杀统计、死亡次数
- 剧情与任务：Mission Sync、任务类型、任务目标、剧情主线、小队成员、小队邀请
- 运行时数据：融合、最近攻击者、Senzu 冷却、保护计时、尾巴模式、负重
- 外观数据：DNS/Skin 字符串、Aura 颜色、外观辅助解析
- 种族专属：赛亚人变身计量、冰冻恶魔族储能、魔人吸收等

如果你需要完整方法列表，直接按分类阅读以下文件会比在一个超长类里翻找更高效：

- [`src/com/cvalue/api/CValueAPIBase.java`](src/com/recvalue/api/CValueAPIBase.java)
- [`src/com/cvalue/api/CValueAPIStats.java`](src/com/recvalue/api/CValueAPIStats.java)
- [`src/com/cvalue/api/CValueAPISkills.java`](src/com/recvalue/api/CValueAPISkills.java)
- [`src/com/cvalue/api/CValueAPIForms.java`](src/com/recvalue/api/CValueAPIForms.java)
- [`src/com/cvalue/api/CValueAPITasks.java`](src/com/recvalue/api/CValueAPITasks.java)

## 底层访问

大多数情况下，推荐直接使用 `CValueAPI`。

如果你确实需要访问更底层的 race-aware 包装器，可以这样写：

```java
import com.recvalue.api.CValueAPI;
import com.recvalue.base.Base;

CValueAPI api = CValueAPI.of(player);
Base raceBase = api.raceData();
int currentStrength = raceBase.getAttributeValue(0);
```

如果你需要兼容旧式视图对象，也仍然可以拿到底层视图：

```java
api.playerView();
```

但对于新代码，仍然建议优先使用 `CValueAPI` 及其分组实例，而不是直接围绕 `CValuePlayerView` 组织业务代码。

## 构建

仓库当前保持 Java 8 约束，直接使用：

```powershell
.\build.ps1
```

如果你只是做本地源码编译验证，也可以使用 Java 8 的 `javac` 对 `src` 全量编译。

## 说明

- `source/JRMCore-v1.3.51.jar.src` 是当前实现的重要对齐参考来源之一
- `ReCValue` 的目标是“让开发者更方便读取 DBC/JRMCore 数据”，而不是替代上游源码
- 某些 JRMCore 内部字段虽然能读到，但如果语义不稳定，当前不会强行包装成公开 API
