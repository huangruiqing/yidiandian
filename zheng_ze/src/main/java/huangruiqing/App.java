package huangruiqing;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] arg) throws Exception {
        String serviceUrl = "http://baiguoyuan.dev.51baiwang.com/bwmg/";//必填 服务地址
        String sellerTaxNo = "51234567890008BWGF";//必填 税号（上传待开的税号）
        String serialNo = "19052300878170653161";//必填 流水号（上传待开的流水号）
        String uploadTime = "1";//选填    单位小时(用于友好提示)
       /* QrElement qrElement = new QrElement();
        qrElement.setServiceUrl(serviceUrl);
        qrElement.setSellerTaxNo(sellerTaxNo);
        qrElement.setSerialNo(serialNo);
        qrElement.setUploadTime(uploadTime);//小时

        String qrUrl = BwCloud.des3EncryptRtnUrl(qrElement);*/

      //  System.out.println(qrUrl);
        //http://mtest.baiwang.com/bwmg/mix/clearsoi?t=512345678900000040&s=BJfff7566744853
        //http://192.168.4.195:8500/clearsoi?t=512345678900000040&s=BJfff75667448533&h=16&d=YY02
        //http://mtest.baiwang-inner.com/mix/clearsoi?t=512345678900000040&s=BJfff7566744853
        //http://pis.baiwang.com/bwmg/mix/soi?t=X_6G6YNF4OzW7pVN1Lb6GrVh22xvjWvm&s=GDLtxiNJjNm5X5dtuIXwLA&h=1&d=RL01
    }
}

