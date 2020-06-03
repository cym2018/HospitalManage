'use strict';
const url={
  url:["/bed/","/recode/","/patient/","/doctor/","/section/"],
  list(tab){
    return this.url[tab]+"list";
  },
  edit(tab,id){
    return this.url[tab]+id;
  },
  lookup(tab){
    return this.url[tab]+"lookup";
  },
  remove(tab,id){
    return this.url[tab]+"remove/"+id;
  },
  save(tab){
    return this.url[tab]+"save";
  }
};
const data={
  entity:"",
  list:[],
  lookup:{
    bed:[],
    doctor:[],
    patient:[],
    recode:[],
    section:[],
  },
  username:getCookie("username"),
};
const page={
  tab:0,
  func:0,
  title:["病床管理", "就诊记录", "患者管理", "医生管理", "科室管理"],
  table:[
          ["id", "床号", "所属科室", "当前病人", "床位状态"],
          ["id", "姓名", "就诊科室", "床号", "就诊状态", "入院时间", "出院时间"],
          ["id", "姓名", "性别", "身份证号", "患者状态", "床号"],
          ["id", "用户名", "姓名", "性别", "年龄", "身份证号", "所在科室"],
          ["id", "科室名称", "地址", "病床总数", "可用床位"]
        ],

}

// 获取url中的值
function getUrl(key) {
  let vars = window.location.search.substring(1).split('&');
  return getVariable(vars, key);
}

// 获取cookie中的值
function getCookie(key) {
  let vars = document.cookie.split('; ');
  return getVariable(vars, key);
}

// 获取字符串中的参数
function getVariable(vars, key) {
  for (let i = 0; i < vars.length; i++) {
    let pair = vars[i].split("=");
    if (pair[0] === key) {
      return pair[1];
    }
  }
  return false;
}
function urlEncoding(object) {
  let ret = '';
  for (let i in object) {
    if (eval('object.' + i) !== null && eval('object.' + i) !== undefined && eval('object.' + i) !== '') {
      ret = ret + '&' + i + '=' + eval("object." + i);
    }
  }
  return ret;
}
function urlEncoding2(object) {
  let ret = '';
  for (let i in object) {
    if (eval('object.' + i) !== null && eval('object.' + i) !== undefined && eval('object.' + i) !== '') {
      ret = ret + '&' + i + '=' + eval("object." + i);
    }
  }
  ret = ret.replace('&', '?');
  return ret;
}
