function Dsy() {
    this.Items = {};
}
Dsy.prototype.add = function (id, iArray) {
    this.Items[id] = iArray;
}
Dsy.prototype.Exists = function (id) {
    if (typeof(this.Items[id]) == "undefined") return false;
    return true;
}

function change(v) {
    var str = "0";
    for (i = 0; i < v; i++) { str += ("_" + (document.getElementById(s[i]).selectedIndex - 1));}
    ;
    var ss = document.getElementById(s[v]);
    with (ss) {
        length = 0;
        options[0] = new Option(opt0[v], opt0[v]);
        if (v && document.getElementById(s[v - 1]).selectedIndex > 0 || !v) {
            if (dsy.Exists(str)) {
                ar = dsy.Items[str];
                for (i = 0; i < ar.length; i++)options[length] = new Option(ar[i], ar[i]);
                if (v)options[0].selected = true;
            }
        }
        if (++v < s.length) {change(v);}
    }
}
function preselect(p_key) {
    //alert(p_key);
    var index;

    var provinces = new Array("北京市", "海南省" ,"香港", "台湾省");
    var cnt = provinces.length;
    //alert(cnt);
    for (i = 0; i < cnt; i++) {
        if (p_key == provinces[i]) {
            index = i;
            break;
        }
    }
    if (index < provinces.length) {
        document.getElementById(s[0]).selectedIndex = index + 1;
        change(1);
    }
}

var dsy = new Dsy();

dsy.add("0_0_0", ["东城区", "西城区", "崇文区", "宣武区", "朝阳区", "丰台区", "石景山区", "海淀区", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "密云县", "延庆县", "延庆镇"]);
dsy.add("0_0", ["北京市"]);
dsy.add("0_1_0", ["龙华区", "秀英区", "琼山区", "美兰区"]);
dsy.add("0_1_2", ["文昌市", "琼海市", "万宁市", "五指山市", "东方市", "儋州市", "临高县", "临城镇", "澄迈县", "金江镇", "定安县", "定城镇", "屯昌县", "屯城镇", "昌江黎族自治县", "石碌镇", "白沙黎族自治县", "牙叉镇", "琼中黎族苗族自治县", "营根镇", "陵水黎族自治县", "椰林镇", "保亭黎族苗族自治县", "保城镇", "乐东黎族自治县", "抱由镇"]);
dsy.add("0_1", ["海口市", "三亚市", "省直辖行政单位"]);
dsy.add("0_2_0", ["中西区", "东区", "九龙城区", "观塘区", "南区", "深水埗区", "湾仔区", "黄大仙区", "油尖旺区", "离岛区", "葵青区", "北区", "西贡区", "沙田区", "屯门区", "大埔区", "荃湾区", "元朗区"]);
dsy.add("0_2", ["香港特别行政区"]);
dsy.add("0_3_0", [" "]);
dsy.add("0_3", ["台北", "高雄", "台中", "花莲", "基隆", "嘉义", "金门", "连江", "苗栗", "南投", "澎湖", "屏东", "台东", "台南", "桃园", "新竹", "宜兰", "云林", "彰化"]);
dsy.add("0", ["北京市", "海南省","香港", "台湾省"]);

var s = ["s1", "s2", "s3"];
var opt0 = ["省份", "地级市", "市、县级市、县"];
function setup() {
    for (i = 0; i < s.length - 1; i++)
        document.getElementById(s[i]).onchange = new Function("change(" + (i + 1) + ");");
    change(0);
}