package de.maxhenkel.voicechat.permission;

import de.maxhenkel.voicechat.Voicechat;
import de.maxhenkel.voicechat.intercompatibility.CommonCompatibilityManager;

import java.util.ArrayList;
import java.util.List;

public abstract class PermissionManager {

    public static PermissionManager INSTANCE = CommonCompatibilityManager.INSTANCE.createPermissionManager();

    public final Permission LISTEN_PERMISSION;
    public final Permission SPEAK_PERMISSION;
    public final Permission GROUPS_PERMISSION;
    public final Permission GROUPS_NORMAL_PERMISSION;
    public final Permission GROUPS_OPEN_PERMISSION;
    public final Permission GROUPS_ISOLATED_PERMISSION;
    public final Permission PHANTOM_JOIN_PERMISSION;
    public final Permission ADMIN_PERMISSION;

    protected List<Permission> permissions = new ArrayList<>();

    public PermissionManager() {
        LISTEN_PERMISSION = createPermission(Voicechat.MODID, "listen", PermissionType.EVERYONE);
        SPEAK_PERMISSION = createPermission(Voicechat.MODID, "speak", PermissionType.EVERYONE);
        GROUPS_PERMISSION = createPermission(Voicechat.MODID, "groups", PermissionType.EVERYONE);
        GROUPS_NORMAL_PERMISSION = createPermission(Voicechat.MODID, "groups.normal", PermissionType.EVERYONE);
        GROUPS_OPEN_PERMISSION = createPermission(Voicechat.MODID, "groups.open", PermissionType.EVERYONE);
        GROUPS_ISOLATED_PERMISSION = createPermission(Voicechat.MODID, "groups.isolated", PermissionType.EVERYONE);
        PHANTOM_JOIN_PERMISSION = createPermission(Voicechat.MODID, "phantom", PermissionType.NOONE);
        ADMIN_PERMISSION = createPermission(Voicechat.MODID, "admin", PermissionType.OPS);
    }

    public abstract Permission createPermissionInternal(String modId, String node, PermissionType type);

    public Permission createPermission(String modId, String node, PermissionType type) {
        Permission p = createPermissionInternal(modId, node, type);
        permissions.add(p);
        return p;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
