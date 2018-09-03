import tr.com.cs.signer.xml.C_XMLValidateInfo;
import tr.com.cs.signer.xml.C_XMLValidater;

import java.io.FileInputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args == null || args.length != 1) {
            System.out.println("Kullanım:");
            System.out.println("java -jar XmlXAdESValidator.jar fatura.xml");
            return;
        }
        try {
            List<C_XMLValidateInfo> valInfs = C_XMLValidater.validate(new FileInputStream(args[0]));
            System.out.println("--- Sonuç ---");
            for (final C_XMLValidateInfo inf: valInfs) {
                System.out.println(inf.getStatus().toString() + ": " + inf.getHata());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
