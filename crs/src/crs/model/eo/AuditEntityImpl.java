package crs.model.eo;

import gen.common.BaseAuditEntityImpl;

import oracle.jbo.server.EntityDefImpl;

public class AuditEntityImpl extends BaseAuditEntityImpl
{ 
  EntityDefImpl auditModificationDefImpl = CrsAuditModificationsImpl.getDefinitionObject();
  
  @Override
  public EntityDefImpl getAuditEntityInstance()
  {
    return auditModificationDefImpl;
  }
}
