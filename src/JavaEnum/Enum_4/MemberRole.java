package JavaEnum.Enum_4;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public enum MemberRole {
    NO_AUTHORITY("NO_AUTHORITY"),
    ROLE_GENERAL_USER("ROLE_GENERAL_USER"),
    ROLE_SALES_PART("ROLE_SALES_PART"),
    ROLE_SALES_PART_MANAGER("ROLE_SALES_PART_MANAGER"),
    ROLE_TECH_PART_MANGER("ROLE_TECH_PART_MANGER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SUPERUSER("ROLE_SUPERUSER");

    private final String role;
    MemberRole(String role) {
        this.role = role;
    }

    public static MemberRole getRoleType(String role){
//        for(MemberRole memberRole : MemberRole.values()){
//            if(memberRole.name().equals(role)){
//                return memberRole;
//            }
//        }
//        return MemberRole.NO_AUTHORITY;
        return Optional.ofNullable(roleMap.get(role))
                .orElse(NO_AUTHORITY);
    }

   public static final Map<String,MemberRole> roleMap =
           Stream.of(values())
                   .collect(Collectors.toMap(Object::toString, Function.identity()));
//    static {
//        roleMap = new HashMap<>();
//        roleMap.put("NO_AUTHORITY",NO_AUTHORITY);
//        roleMap.put("ROLE_GENERAL_USER",ROLE_GENERAL_USER);
//        roleMap.put("ROLE_SALES_PART",ROLE_SALES_PART);
//        roleMap.put("ROLE_SALES_PART_MANAGER",ROLE_SALES_PART_MANAGER);
//        roleMap.put("ROLE_TECH_PART_MANGER",ROLE_TECH_PART_MANGER);
//        roleMap.put("ROLE_ADMIN",ROLE_ADMIN);
//        roleMap.put("ROLE_SUPERUSER",ROLE_SUPERUSER);
//    }
}
