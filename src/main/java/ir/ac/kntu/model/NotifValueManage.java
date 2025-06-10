package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.*;

public class NotifValueManage {
    private static final NotifValueManage notValManInstance = new NotifValueManage();
    private Map<LocalDateTime,String> pubMessageNotif = new HashMap<>();
    private Map<RegularUser,List<DiscountCode>> discountCodeNotif = new HashMap<>();
    private Map<RegularUser,List<ManageUserSupport>> reqnotif = new HashMap<>();
    private Map<RegularUser,List<Products>> prodNotif = new HashMap<>();

    public static NotifValueManage getNotValManInstance(){
        return notValManInstance;
    }

    public void addPubMessNotif(LocalDateTime date,String message){
        pubMessageNotif.put(date,message);
    }
    public String getNotifValue1(LocalDateTime date){
        for(Map.Entry<LocalDateTime,String> pmnf : pubMessageNotif.entrySet()){
            if(pmnf.getKey().equals(date)){
                return pmnf.getValue();
            }
        }
        return null;
    }

    public void addCodeNotif(RegularUser user , DiscountCode code){
        discountCodeNotif.computeIfAbsent(user, k -> new ArrayList<>()).add(code);
    }

    public List<DiscountCode> getNotifValue2(RegularUser user){
        return discountCodeNotif.getOrDefault(user, Collections.emptyList());
    }

    public void addreqNotif(RegularUser user , ManageUserSupport requ){
        reqnotif.computeIfAbsent(user, k -> new ArrayList<>()).add(requ);
    }

    public List<ManageUserSupport> getNotifValue3(RegularUser user){
        return reqnotif.getOrDefault(user, Collections.emptyList());
    }

    public void addprodNotif(RegularUser user , Products prod){
        prodNotif.computeIfAbsent(user, k -> new ArrayList<>()).add(prod);
    }

    public List<Products> getNotifValue4(RegularUser user){
        return prodNotif.getOrDefault(user, Collections.emptyList());
    }


}
