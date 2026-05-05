package com.avaje.ebeaninternal.server.ddl;

import com.avaje.ebeaninternal.server.deploy.BeanProperty;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocMany;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocOne;
import com.avaje.ebeaninternal.server.deploy.BeanPropertyCompound;

public abstract class AbstractPropertyVisitor implements PropertyVisitor {
  public void visitEmbedded(BeanPropertyAssocOne<?> p) {}
  
  public void visitEmbeddedScalar(BeanProperty p, BeanPropertyAssocOne<?> embedded) {}
  
  public void visitMany(BeanPropertyAssocMany<?> p) {}
  
  public void visitOneExported(BeanPropertyAssocOne<?> p) {}
  
  public void visitOneImported(BeanPropertyAssocOne<?> p) {}
  
  public void visitScalar(BeanProperty p) {}
  
  public void visitCompound(BeanPropertyCompound p) {}
  
  public void visitCompoundScalar(BeanPropertyCompound compound, BeanProperty p) {}
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ddl\AbstractPropertyVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */