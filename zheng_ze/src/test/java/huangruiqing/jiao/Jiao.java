package huangruiqing.jiao;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Jiao
 * @Description
 * @Author huangrq
 * @Date 2019/2/12 16:21
 */
public class Jiao {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 5, 17);
        Date initDate = calendar.getTime();
        System.out.println("起始:" + initDate);
        calendar.set(2048, 5, 17);
        Date endDate = calendar.getTime();
        System.out.println("截至:" + endDate);
        Period period = new Period(initDate.getTime(), endDate.getTime(), PeriodType.days());
        int intervalDay = period.getDays();
        System.out.println("间隔天数:" + intervalDay);
        BigDecimal benJin = new BigDecimal("100000");//本金
        BigDecimal yearLiLv = new BigDecimal("0.588");//年利率
        BigDecimal yueShu = new BigDecimal("12");
        BigDecimal qiShu = new BigDecimal("12");//12 * 20
        BigDecimal moLiLv = yearLiLv.divide(yueShu,4,RoundingMode.HALF_UP);//月利率
        System.out.println("月利率:" + moLiLv);
        /*
        每月月供额=〔贷款本金×月利率 ×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
        每月应还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕÷〔(1+月利率)^还款月数-1〕
        每月应还本金=贷款本金×月利率×(1+月利率)^(还款月序号-1)÷〔(1+月利率)^还款月数-1〕
        总利息=还款月数×每月月供额-贷款本金
         */
        //double s = Math.pow(2,3);
        int sacle = 4;
        BigDecimal jiShu = new BigDecimal("1");//基数 1



        BigDecimal yi_add_mo = jiShu.add(moLiLv).setScale(sacle,RoundingMode.HALF_UP);// 1+ 月利率
        BigDecimal cimi = yi_add_mo.pow(qiShu.intValue()).setScale(sacle,RoundingMode.HALF_UP);//(1＋月利率)＾还款月数
        BigDecimal b_X_mo = benJin.multiply(moLiLv).setScale(sacle,RoundingMode.HALF_UP);//贷款本金×月利率
        BigDecimal yueGong1 = b_X_mo.multiply(cimi).setScale(sacle,RoundingMode.HALF_UP);//贷款本金×月利率 ×(1＋月利率)
        BigDecimal cimi2 = yi_add_mo.pow(qiShu.subtract(jiShu).intValue()).setScale(sacle,RoundingMode.HALF_UP);//(1+月利率)^还款月数-1
     //   BigDecimal cimi2 = yi_add_mo.pow(qiShu.intValue()).subtract(jiShu).setScale(sacle,RoundingMode.HALF_UP);//(1+月利率)^还款月数-1
        BigDecimal yueGong2 = yueGong1.divide(cimi2,sacle,RoundingMode.HALF_UP);

        System.out.println("result：" + yueGong2);

    }


}
