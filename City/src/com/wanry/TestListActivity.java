package com.wanry;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;

public class TestListActivity extends Activity implements
		com.wanry.MySideBar.OnTouchingLetterChangedListener {

	private ListView mainList;
	/** 数据源 */
	private List<String> data;
	/** 字母位置 */
	private List<Integer> letterPositionList;
	/** 字母Char */
	private List<Integer> letterCharList;
	private MySideBar myView;
	private TextView tv01;
	private String[] title = {"GPS定位城市", "热门城市", "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	private int lastFirstVisibleItem;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mainList = (ListView) findViewById(R.id.mainlist);
		myView = (MySideBar) findViewById(R.id.myview);
		tv01 = (TextView) findViewById(R.id.main_tv01);

		myView.setOnTouchingLetterChangedListener(this);
		data = new ArrayList<String>();
		letterCharList = new ArrayList<Integer>();
		letterPositionList = new ArrayList<Integer>();

		int index = 0, position = 0;
		letterCharList.add(index);
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[i].length; j++) {
				if (i == 0 && j == 0) {
					index++;
					letterPositionList.add(position);
				} else if (j == 0) {
					letterCharList.add(index);
					letterPositionList.add(position);
					index++;
				} else {
					letterCharList.add(-1);
				}
				position++;
				data.add(ary[i][j]);
			}
		}
		MyAdapter adapter = new MyAdapter(this, data, letterCharList, title);
		mainList.setAdapter(adapter);
		mainList.setOnScrollListener(new OnScrollListener() {

			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (letterCharList.get(firstVisibleItem) >= 0) {
					tv01.setText(title[letterCharList.get(firstVisibleItem)]);
					lastFirstVisibleItem = firstVisibleItem;
				} else {
					if (lastFirstVisibleItem > firstVisibleItem) {
						tv01.setText(title[letterCharList
								.get(lastFirstVisibleItem) - 1]);
					}
				}
			}
		});
	}

	public void onTouchingLetterChanged(int s) {
		mainList.setSelection(letterPositionList.get(s));
	}

	/** 数据源二维数组 */
	private String[][] ary = {
			
			{"正在定位..."},
			// 热门城市
			{ "北京", "上海", "石家庄", "昆明", "杭州", "广州", "成都", "西安", "南京", "深圳",
					"重庆", "长沙", "沈阳", "厦门", "武汉", "海口", "乌鲁木齐", "青岛", "大连",
					"三亚", "哈尔滨", "长春", "南宁", "贵阳", "福州", "郑州", "济南", "桂林",
					"天津", "太原", "南昌" },
			// A
			{ "鞍山市", "安庆市", "安阳市", "阿坝藏族羌族自治州", "安顺市", "安康市", "阿里地区", "阿勒泰地区",
					"阿克苏地区", "阿拉尔市", "阿拉善盟", "澳门特别行政区" },
			// B

			{ "北京市", "保定市", "本溪市", "白城市", "白山市", "蚌埠市", "亳州市", "滨州市", "白银市",
					"巴中市", "毕节地区", "白沙黎族自治县", "保亭黎族苗族自治县", "保山市", "宝鸡市", "百色市",
					"北海市", "博尔塔拉蒙古自治州", "巴音郭楞蒙古自治州", "包头市", "巴彦淖尔市" },
			// C

			{ "长沙市", "承德市", "沧州市", "朝阳市", "常州市", "滁州市", "巢湖市", "池州市", "郴州市",
					"常德市", "潮州市", "成都市", "澄迈县", "昌江黎族自治县", "楚雄彝族自治州", "崇左市",
					"昌都地区", "昌吉回族自治州", "赤峰市" },
			// D

			{ "大同市", "大连市", "丹东市", "大兴安岭地区", "大庆市", "德州市", "东营市", "东莞市", "定西市",
					"达州市", "德阳市", "儋州市", "东方市", "定安县", "德宏傣族景颇族自治州", "大理白族自治州",
					"迪庆藏族自治州" },
			// E

			{ "恩施市", "鄂州市", "鄂尔多斯市" },

			// F

			{ "抚顺市", "阜新市", "阜阳市", "福州市", "抚州市", "佛山市", "防城港市" },
			// G

			{ "赣州市", "广州市", "甘南藏族自治州", "广安市", "甘孜藏族自治州", "广元市", "贵阳市",
					"果洛藏族自治州", "桂林市", "贵港市", "固原市", "高雄市" },
			// H

			{ "衡水市", "呼和浩特市", "呼伦贝尔市", "和田地区", "哈密地区", "河池市", "贺州市", "汉中市",
					"海西蒙古族藏族自治州", "邯郸市", "海南藏族自治州", "黄南藏族自治州", "海东地区",
					"海北藏族自治州", "红河哈尼族彝族自治州", "海口市", "河源市", "惠州市", "怀化市", "衡阳市",
					"黄石市", "黄冈市", "鹤壁市", "菏泽市", "黄山市", "淮北市", "淮南市", "合肥市",
					"湖州市", "杭州市", "淮安市", "黑河市", "鹤岗市", "哈尔滨市", "葫芦岛市" },
			// I
			{ "暂无" },
			// J

			{ "嘉义市", "基隆市", "酒泉市", "嘉峪关市", "金昌市", "江门市", "揭阳市", "荆门市", "荆州市",
					"焦作市", "济源市", "济宁市", "济南市", "景德镇市", "吉安市", "九江市", "金华市",
					"嘉兴市", "佳木斯市", "鸡西市", "吉林市", "锦州市", "晋城市", "晋中市" },
			// K

			{ "开封市", "昆明市", "克孜勒苏柯尔克孜自治州", "克拉玛依市", "喀什地区" },
			// L

			{ "林芝地区", "拉萨市", "柳州市", "来宾市", "丽江市", "临沧市", "陵水黎族自治县", "乐东黎族自治县",
					"临高县", "六盘水市", "凉山彝族自治州", "乐山市", "泸州市", "临夏回族自治州", "陇南市",
					"兰州市", "娄底市", "漯河市", "洛阳市", "聊城市", "莱芜市", "临沂市", "龙岩市",
					"六安市", "丽水市", "连云港市", "辽源市", "辽阳市", "吕梁市", "临汾市", "廊坊市" },
			// M

			{ "牡丹江市", "马鞍山市", "茂名市", "梅州市", "绵阳市", "眉山市" },
			// N

			{ "南京市", "南通市", "宁波市", "宁德市", "南平市", "南昌市", "南阳市", "南充市", "内江市",
					"怒江傈傈族自治州", "南宁市", "那曲地区" },
			// O
			{ "暂无" },
			// P

			{ "盘锦市", "莆田市", "萍乡市", "平顶山市", "濮阳市", "平凉市", "攀枝花市", "普洱市" },
			// Q

			{ "秦皇岛市", "齐齐哈尔市", "七台河市", "衢州市", "泉州市", "青岛市", "潜江市", "清远市",
					"庆阳市", "黔南布依族苗族自治州", "黔东南苗族侗族自治州", "黔西南布依族苗族自治州", "琼海市",
					"琼中黎族苗族自治县", "曲靖市", "钦州市" },
			// R

			{ "日照市", "日喀则地区" },
			// S
			{ "上海市", "石家庄市", "朔州市", "沈阳市", "四平市", "松原市", "双鸭山市", "绥化市", "苏州市",
					"宿迁市", "绍兴市", "宿州市", "厦门市", "三明市", "上饶市", "商丘市", "三门峡市",
					"神农架林区", "十堰市", "随州市", "邵阳市", "汕尾市", "韶关市", "汕头市", "深圳市",
					"遂宁市", "三亚市", "商洛市", "山南地区", "石嘴山市", "石河子市" },
			// T

			{ "天津市", "唐山市", "太原市", "铁岭市", "通化市", "泰州市", "台州市", "铜陵市", "泰安市",
					"天门市", "天水市", "铜仁地区", "屯昌县", "铜川市", "塔城地区", "吐鲁番地区",
					"图木舒克市", "通辽市", "台北市", "台中市", "台南市" },
			// U
			{ "暂无" },
			// V
			{ "暂无" },
			// W

			{ "无锡市", "温州市", "芜湖市", "潍坊市", "威海市", "武汉市", "武威市", "五指山市", "文昌市",
					"万宁市", "文山壮族苗族自治州", "渭南市", "梧州市", "吴忠市", "乌鲁木齐市", "五家渠市",
					"乌海市", "乌兰察布市" },
			// X

			{ "邢台市", "忻州市", "徐州市", "宣城市", "新余市", "新乡市", "许昌市", "信阳市", "襄阳市",
					"孝感市", "咸宁市", "仙桃市", "湘潭市", "湘西土家族苗族自治州", "西双版纳傣族自治州",
					"西宁市", "西安市", "咸阳市", "锡林郭勒盟", "兴安盟", "新竹市", "香港特别行政区" },
			// Y

			{ "阳泉市", "运城市", "营口市", "延边朝鲜族自治州", "伊春市", "扬州市", "盐城市", "鹰潭市",
					"宜春市", "烟台市", "宜昌市", "岳阳市", "益阳市", "永州市", "阳江市", "云浮市",
					"宜宾市", "雅安市", "玉溪市", "玉树藏族自治州", "延安市", "榆林市", "玉林市", "银川市",
					"伊犁哈萨克自治州" },
			// Z

			{ "重庆市", "张家口市", "长治市", "长春市", "镇江市", "舟山市", "漳州市", "淄博市", "枣庄市",
					"郑州市", "周口市", "驻马店市", "株洲市", "张家界市", "珠海市", "肇庆市", "湛江市",
					"中山市", "张掖市", "自贡市", "资阳市", "遵义市", "昭通市", "中卫市" } };
}