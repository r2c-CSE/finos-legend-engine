package org.finos.legend.engine.protocol.pure.v1.model.packageableElement.persistence.batch.auditing;

public class OpaqueAuditing extends Auditing
{
    @Override
    public <T> T accept(AuditingVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}