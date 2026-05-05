# ReCValue

[中文](README.md) | [English](README_EN.md)

## Overview

`ReCValue` is a value-access and helper facade built around Dragon Block C / JRMCore.

Its goal is not to replace JRMCore. Instead, it consolidates the common read paths that used to be scattered across `Base`, `Util`, `Player`, and other legacy classes into a stable, developer-friendly facade so other developers can directly access:

- levels, attributes, Ki/Body/Stamina, and core combat values
- skills, skill slots, attribute bonuses, and player setting flags
- forms, mastery, status effects, and runtime combat state
- missions, saga/group data, fusion data, and other runtime payloads
- race-specific values and transformation preferences

For compatibility with existing integrations, the public API naming still keeps prefixes such as `CValueAPI`, `CValueAPIStats`, and `CValueAttribute`.

The recommended source-side entry point is now [`src/com/cvalue/api/CValueAPI.java`](src/com/recvalue/api/CValueAPI.java).

## Target Environment

- Minecraft / Forge 1.7.10
- Dragon Block C + JRMCore
- Java 8
- Primarily designed for `net.minecraft.entity.player.EntityPlayer`

If you need a Bukkit-side bridge, verify that your runtime truly provides a hybrid object model compatible with DBC/JRMCore. The API under `src` is still fundamentally built around mod-side `EntityPlayer`.

## API Layout

The API is currently organized into the following groups, all exposed from `CValueAPI`:

- [`CValueAPI`](src/com/recvalue/api/CValueAPI.java): main entrypoint, returns player-bound instances and grouped views
- [`CValueAPIBase`](src/com/recvalue/api/CValueAPIBase.java): base entrypoints, race access, global helpers, and low-level view access
- [`CValueAPIStats`](src/com/recvalue/api/CValueAPIStats.java): levels, attributes, Ki/Body/Stamina, combat stats, percentages, derived values
- [`CValueAPISkills`](src/com/recvalue/api/CValueAPISkills.java): skills, skill slots, learned skills, attribute bonuses, player settings
- [`CValueAPIForms`](src/com/recvalue/api/CValueAPIForms.java): forms, mastery, status effects, alignment, appearance, runtime state
- [`CValueAPITasks`](src/com/recvalue/api/CValueAPITasks.java): missions, saga/group data, fusion data, and related runtime information

Supporting enums and types:

- [`CValueAttribute`](src/com/recvalue/api/CValueAttribute.java): attribute enum, avoids hardcoded `0~5`
- [`CValueStatusEffect`](src/com/recvalue/api/CValueStatusEffect.java): common status-effect enum
- [`CValuePlayerSetting`](src/com/recvalue/api/CValuePlayerSetting.java): player-setting enum
- [`CValueTaskType`](src/com/recvalue/api/CValueTaskType.java): task-type enum

Race implementations live under:

- [`src/com/cvalue/base/race`](src/com/recvalue/base/race)

## Recommended Usage

### 1. Direct static access

Best when you only need one or two values.

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

### 2. Bind once, read many values

Best when you need multiple values from the same player.

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

### 3. Use grouped accessors for readability

If you want clearer code organization, use the grouped instance accessors explicitly:

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

### 4. Use enums instead of magic values

```java
int strength = CValueAPI.getAttribute(player, CValueAttribute.STRENGTH);
boolean kaioken = CValueAPI.hasStatusEffect(player, CValueStatusEffect.KAIOKEN);

int kaiokenSetting = CValueAPI.getPlayerSettingValue(player, CValuePlayerSetting.KAIOKEN);
boolean hasMainDbcTask = CValueAPI.hasTaskType(player, CValueTaskType.MAIN_DBC);
```

## Race-Specific APIs

Some values only make sense for specific races. Those methods are exposed on the corresponding race classes instead of being forced into the generic facade.

### Saiyan

```java
int saiyanMeter = CValueAPI.saiyan(player).getSaiyanTransformationMeter();
boolean godRoute = CValueAPI.saiyan(player).isSaiyanTransformTypeGodSelected();
String preferredForm = CValueAPI.saiyan(player).getPreferredSaiyanTransformationFormName();
```

### Arcosian

```java
int reserve = CValueAPI.arcosian(player).getPowerPointReserve();
int transformMode = CValueAPI.arcosian(player).getArcosianTransformTypeMode();
String preferredForm = CValueAPI.arcosian(player).getPreferredArcosianTransformationFormName();
```

### Majin

```java
int absorption = CValueAPI.majin(player).getAbsorptionValue();
int absorptionTimer = CValueAPI.majin(player).getAbsorptionTimer();
String preferredForm = CValueAPI.majin(player).getPreferredMajinTransformationFormName();
```

You can also access:

- `CValueAPI.human(player)`
- `CValueAPI.halfSaiyan(player)`
- `CValueAPI.namekian(player)`

to use the corresponding race-specific methods.

## Covered Data Categories

The current facade already covers the following major categories:

- core stats: level, attributes, max Ki, max Body, max Stamina, melee, Ki damage, running, flying
- current values: current Body, current Energy, current Stamina, percentages, release, state values
- skills and progression: skill levels, skill slots, learned skills, training points, attribute points, experience, gravity training
- forms and status: current form, mastery, status effects, UI Heat, God Strain, Pain Timer, transformation meter
- alignment and counters: alignment, karma, kill counters, death count
- missions and saga data: mission sync, task types, task targets, main saga, group members, group invites
- runtime payloads: fusion, last attacker, senzu cooldown, protection timers, tail mode, weight
- appearance data: DNS/Skin strings, aura color, appearance helper parsing
- race-specific values: Saiyan transformation meter, Arcosian reserve, Majin absorption, and more

If you need the full method list, reading the grouped source files directly is much easier than navigating one giant class:

- [`src/com/cvalue/api/CValueAPIBase.java`](src/com/recvalue/api/CValueAPIBase.java)
- [`src/com/cvalue/api/CValueAPIStats.java`](src/com/recvalue/api/CValueAPIStats.java)
- [`src/com/cvalue/api/CValueAPISkills.java`](src/com/recvalue/api/CValueAPISkills.java)
- [`src/com/cvalue/api/CValueAPIForms.java`](src/com/recvalue/api/CValueAPIForms.java)
- [`src/com/cvalue/api/CValueAPITasks.java`](src/com/recvalue/api/CValueAPITasks.java)

## Low-Level Access

In most cases, `CValueAPI` is the recommended surface.

If you really need the lower-level race-aware wrapper, you can still do this:

```java
import com.recvalue.api.CValueAPI;
import com.recvalue.base.Base;

CValueAPI api = CValueAPI.of(player);
Base raceBase = api.raceData();
int currentStrength = raceBase.getAttributeValue(0);
```

If you need the underlying compatibility view, you can still access:

```java
api.playerView();
```

For new code, `CValueAPI` and its grouped instances should remain the primary choice over organizing business logic around `CValuePlayerView`.

## Build

This repository currently keeps the Java 8 constraint:

```powershell
.\build.ps1
```

For local source verification, compiling the entire `src` tree with Java 8 `javac` is also valid.

## Notes

- `source/JRMCore-v1.3.51.jar.src` is one of the key alignment references for the current implementation
- the goal of `ReCValue` is to make DBC/JRMCore data easier to read, not to replace upstream source
- some JRMCore internal fields are intentionally not exposed as public facade APIs when their semantics are not stable enough
