package com.cwu.emallseckill;

import com.cwu.emallseckill.dao.GoodsMapper;
import com.cwu.emallseckill.dao.OrderInfoMapper;
import com.cwu.emallseckill.dao.SeckillOrderMapper;
import com.cwu.emallseckill.dao.UserMapper;
import com.cwu.emallseckill.entity.Goods;
import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.entity.SeckillOrder;
import com.cwu.emallseckill.param.LoginParam;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@MapperScan("com.cwu.emallseckill.dao")
class EmallSeckillApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void checkPhone(){
        System.out.println(this.userMapper.checkPhone("18077200000"));
    }
//
    @Test
    void selectByPhoneAndPassword(){
        System.out.println(this.userMapper.selectByPhoneAndPassword("18077200000","123456"));
    }

    @Test
    void login(){
        LoginParam param=new LoginParam();
        param.setMobile("18077200000");
        param.setPassword("123456");
        Result result=this.userService.login(param);
        System.out.println("[Code]"+result.getCode());
        System.out.println("[Msg]"+result.getMsg());
        System.out.println("[Data]"+result.getData());
    }

    @Test
    void testSelect(){
        System.out.println(this.goodsMapper.selectByPrimaryKey(7L));
    }

    @Test
    void testSekillGoodsBo(){
        System.out.println(this.goodsMapper.getSeckillGoodsBoByGoodsId(1L));
    }

    @Test
    void testSelAllGoods(){
        System.out.println(this.goodsMapper.selectAllGoods());
    }

    @Test
    void testDel(){
        System.out.println(this.goodsMapper.deleteByPrimaryKey(7L));
    }

    @Test
    void testUpdateBasic(){
        Goods goods=new Goods();
        goods.setId(7L);
        goods.setGoods_img("//img14.360buyimg.com/n1/s450x450_jfs/t1/145143/29/1636/222889/5ef831dbE4ece7453/5969340589cdabcb.jpg");
        goods.setGoods_name("联想(Lenovo)小新Air14");
        goods.setGoods_title("联想(Lenovo)小新Air14性能版轻薄本 英特尔酷睿i5 全面屏学生独显笔记本电脑(i5 16G 512G MX350 高色域)银");
        goods.setGoods_price(new BigDecimal(5299.00));
        goods.setGoods_stock(800);
        goods.setUpdate_date(new Date());
        this.goodsMapper.updateByPrimaryKey(goods);
    }

    @Test
    void testUpdate(){
        Goods goods=new Goods();
        goods.setId(7L);
        goods.setGoods_detail("品牌： 联想（Lenovo）\n" +
                "商品名称：联想小新Air14\n商品编号：100011386554\n商品毛重：2.18kg\n商品产地：中国大陆\n显卡类别：独立显卡\n类型：轻薄笔记本\n优选服务：两年质保\n厚度：15.1mm—18.0mm\n机身材质：金属材质特性：指纹识别，全面屏，快充屏幕\n尺寸：14.0英寸-14.9英寸\n系列：联想 - 小新Air\n裸机重量：1-1.5KG\n屏幕色域：100%sRGB\n机械硬盘：无机械硬盘\n处理器：Intel i5\n屏幕刷新率：其他\n待机时长：7-9小时\n内存容量：16G\n显卡型号：NVIDIA MX350\n系统：windows 10 带Office\n固态硬盘（SSD）：512GB\n颜色：银色");
        goods.setGoods_img("//img14.360buyimg.com/n1/s450x450_jfs/t1/145143/29/1636/222889/5ef831dbE4ece7453/5969340589cdabcb.jpg");
        goods.setGoods_name("联想(Lenovo)小新Air14");
        goods.setGoods_title("联想(Lenovo)小新Air14性能版轻薄本 英特尔酷睿i5 全面屏学生独显笔记本电脑(i5 16G 512G MX350 高色域)银");
        goods.setGoods_price(new BigDecimal(5299.00));
        goods.setGoods_stock(900);
        goods.setUpdate_date(new Date());
        this.goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
    }

    @Test
    void testInsert(){
        Goods goods=new Goods();
        goods.setCreate_date(new Date());
        goods.setGoods_detail("品牌： 联想（Lenovo）\n" +
                "商品名称：联想小新Air14商品编号：100011386554商品毛重：2.18kg商品产地：中国大陆显卡类别：独立显卡类型：轻薄笔记本优选服务：两年质保厚度：15.1mm—18.0mm机身材质：金属材质特性：指纹识别，全面屏，快充屏幕尺寸：14.0英寸-14.9英寸系列：联想 - 小新Air裸机重量：1-1.5KG屏幕色域：100%sRGB机械硬盘：无机械硬盘处理器：Intel i5屏幕刷新率：其他待机时长：7-9小时内存容量：16G显卡型号：NVIDIA MX350系统：windows 10 带Office固态硬盘（SSD）：512GB颜色：银色\n"
                +"售后保障\n" +
                " 厂家服务\n" +
                "本产品全国联保，享受三包服务，质保期为：两年有限质保\n" +
                "如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！\n" +
                "(注:如厂家在商品介绍中有售后保障的说明,则此商品按照厂家说明执行售后保障服务。) 您可以查询本品牌在各地售后服务中心的联系方式，请点击这儿查询......\n" +
                "\n" +
                "品牌官方网站：http://www.lenovo.com.cn/\n" +
                "售后服务电话：400-990-8888\n" +
                " 京东承诺\n" +
                "京东平台卖家销售并发货的商品，由平台卖家提供发票和相应的售后服务。请您放心购买！\n" +
                "注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！\n" +
                "正品行货\n" +
                "京东商城向您保证所售商品均为正品行货，京东自营商品开具机打发票或电子发票。\n" +
                "全国联保\n" +
                "凭质保证书及京东商城发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由京东联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。京东商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！\n" +
                "\n" +
                "注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！\n" +
                "无忧退货\n" +
                "客户购买京东自营商品7日内（含7日，自客户收到商品之日起计算），在保证商品完好的前提下，可无理由退货。（部分商品除外，详情请见各商品细则）\n" +
                "权利声明：\n" +
                "京东上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东重要的经营资源，未经许可，禁止非法转载使用。\n" +
                "注：本站商品信息均来自于合作方，其真实性、准确性和合法性由信息拥有者（合作方）负责。本站不提供任何保证，并不承担任何法律责任。\n" +
                "\n" +
                "\n" +
                "价格说明：\n" +
                "京东价：京东价为商品的销售价，是您最终决定是否购买商品的依据。\n" +
                "\n" +
                "划线价：商品展示的划横线价格为参考价，并非原价，该价格可能是品牌专柜标价、商品吊牌价或由品牌供应商提供的正品零售价（如厂商指导价、建议零售价等）或该商品在京东平台上曾经展示过的销售价；由于地区、时间的差异性和市场行情波动，品牌专柜标价、商品吊牌价等可能会与您购物时展示的不一致，该价格仅供您参考。\n" +
                "\n" +
                "折扣：如无特殊说明，折扣指销售商在原价、或划线价（如品牌专柜标价、商品吊牌价、厂商指导价、厂商建议零售价）等某一价格基础上计算出的优惠比例或优惠金额；如有疑问，您可在购买前联系销售商进行咨询。\n" +
                "\n" +
                "异常问题：商品促销信息以商品详情页“促销”栏中的信息为准；商品的具体售价以订单结算页价格为准；如您发现活动商品售价或促销信息有异常，建议购买前先联系销售商咨询。\n" +
                "\n" +
                "\n" +
                "能效标识说明：\n" +
                "根据国家相关能效标识法规和标准的要求，京东自营在售商品的能效标识图样，将会逐步替换为新版能源效率标识贴；受能效标识标准变化影响，部分产品的新版和旧版能效标识，在能效等级、测试值等方面会有差异，但产品实际性能完全一样，并不影响购买和使用，加贴新版或旧版能效标识的商品会随机发放，请您放心购买；如有疑问，请在购买前通过咚咚或来电咨询。");
        goods.setGoods_img("//img14.360buyimg.com/n1/s450x450_jfs/t1/145143/29/1636/222889/5ef831dbE4ece7453/5969340589cdabcb.jpg");
        goods.setGoods_name("联想(Lenovo)小新Air14");
        goods.setGoods_title("联想(Lenovo)小新Air14性能版轻薄本 英特尔酷睿i5 全面屏学生独显笔记本电脑(i5 16G 512G MX350 高色域)银");
        goods.setGoods_price(new BigDecimal(5299.00));
        goods.setGoods_stock(100);
        goods.setUpdate_date(new Date());
        this.goodsMapper.insert(goods);
    }

    @Test
    void testSeckillOrderByUserAndGoodsId(){
        System.out.println(this.seckillOrderMapper.selectByUserIdAndGoodsId(1410080408,2));
    }

    @Test
    void testUpdateStock(){
        System.out.println(this.goodsMapper.updateStock(1));
    }

    @Test
    void testOrderInsert(){
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setUser_id(1L);
        orderInfo.setGoods_id(2L);
        orderInfo.setAddr_id(0L);
        orderInfo.setGoods_name("xiaomi 8");
        orderInfo.setGoods_count(1);
        orderInfo.setGoods_price(new BigDecimal(2699.00));
        orderInfo.setOrder_channel(1);
        orderInfo.setStatus(0);
        orderInfo.setCreate_date(new Date());
        orderInfo.setPay_date(null);
        this.orderInfoMapper.insert(orderInfo);
    }

    @Test
    void testQueryOrderInfo(){
        System.out.println(this.orderInfoMapper.selectByPrimaryKey(43L));
    }

    @Test
    void testInsertSelective(){
        SeckillOrder order=new SeckillOrder();
        order.setUserId(1410080408L);
        order.setGoodsId(1L);
        order.setOrderId(2L);
        this.seckillOrderMapper.insertSelective(order);
    }

    @Test
    void testSeckillOrderByUserId(){
        System.out.println(this.seckillOrderMapper.selectByUserId(1410080408L));
    }

    @Test
    void testSeckillOrderByPrimary(){
        System.out.println(this.seckillOrderMapper.selectByPrimaryKey(50L));
    }

    @Test
    void testSeckillOrderByOrderId(){
        System.out.println(this.seckillOrderMapper.selectByOrderId(51L));
    }
}
