(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{f820:function(e,n,t){"use strict";t.r(n);var o=t("7a23"),s={class:"about"},a=Object(o["h"])("h1",null,"This an test page to recieve JSON",-1),c=Object(o["h"])("br",null,null,-1),r={key:0};function u(e,n,t,u,l,b){return Object(o["q"])(),Object(o["d"])("div",s,[a,c,Object(o["h"])("button",{onClick:n[1]||(n[1]=function(e){return b.pullInfo()})},"Pull Info"),e.showResponse?(Object(o["q"])(),Object(o["d"])("div",r,[Object(o["h"])("h6",null,Object(o["y"])(e.serverResponse),1)])):Object(o["e"])("",!0)])}var l=t("bc3a"),b=t.n(l),i={name:"About",data:function(){return{showResponse:!1,serverResponse:""}},methods:{pullInfo:function(){var e=this;b.a.get("/api/info/").then((function(n){e.event=n.data,console.log("Pulled server data "+n.data),e.serverResponse=n.data,e.showResponse=!0})).catch((function(n){e.errors=n.response.data.message}))}}};i.render=u;n["default"]=i}}]);
//# sourceMappingURL=about.7e192cd7.js.map