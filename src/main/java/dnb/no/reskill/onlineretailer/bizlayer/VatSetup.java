package dnb.no.reskill.onlineretailer.bizlayer;


import java.util.ArrayList;
import java.util.Collection;

public class VatSetup {

    Collection<VatPolicy> vatPolicyCollection = new ArrayList<>();

    public void addVatPolicy(VatPolicy vp) {
        vatPolicyCollection.add(vp);
    }

    public int getVatPercentageByPrice (double price) {
        return vatPolicyCollection.stream()
                .filter( v -> price >= v.getFromPrice() && price <= v.getToPrice())
                .findFirst()
                .get()
                .getVatPercentage();
    }

}