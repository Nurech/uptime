(function(e){function t(t){for(var n,a,o=t[0],u=t[1],l=t[2],b=0,d=[];b<o.length;b++)a=o[b],Object.prototype.hasOwnProperty.call(c,a)&&c[a]&&d.push(c[a][0]),c[a]=0;for(n in u)Object.prototype.hasOwnProperty.call(u,n)&&(e[n]=u[n]);i&&i(t);while(d.length)d.shift()();return s.push.apply(s,l||[]),r()}function r(){for(var e,t=0;t<s.length;t++){for(var r=s[t],n=!0,o=1;o<r.length;o++){var u=r[o];0!==c[u]&&(n=!1)}n&&(s.splice(t--,1),e=a(a.s=r[0]))}return e}var n={},c={app:0},s=[];function a(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,a),r.l=!0,r.exports}a.m=e,a.c=n,a.d=function(e,t,r){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(a.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)a.d(r,n,function(t){return e[t]}.bind(null,n));return r},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],u=o.push.bind(o);o.push=t,o=o.slice();for(var l=0;l<o.length;l++)t(o[l]);var i=u;s.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("cd49")},"1c23":function(e,t,r){"use strict";r("560d")},"1cd9":function(e,t,r){},"560d":function(e,t,r){},cc6b:function(e,t,r){"use strict";r("f2c6")},cd49:function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("7a23"),c={id:"nav"},s=Object(n["f"])("Hello"),a=Object(n["f"])(" | "),o=Object(n["f"])("Service"),u=Object(n["f"])(" | "),l=Object(n["f"])("Bootstrap"),i=Object(n["f"])(" | "),b=Object(n["f"])("User"),d=Object(n["f"])(" | "),p=Object(n["f"])("Login"),g=Object(n["f"])(" | "),O=Object(n["f"])("Protected");function j(e,t){var r=Object(n["w"])("router-link"),j=Object(n["w"])("router-view");return Object(n["p"])(),Object(n["d"])(n["a"],null,[Object(n["g"])("div",c,[Object(n["g"])(r,{to:"/"},{default:Object(n["C"])((function(){return[s]})),_:1}),a,Object(n["g"])(r,{to:"/callservice"},{default:Object(n["C"])((function(){return[o]})),_:1}),u,Object(n["g"])(r,{to:"/bootstrap"},{default:Object(n["C"])((function(){return[l]})),_:1}),i,Object(n["g"])(r,{to:"/user"},{default:Object(n["C"])((function(){return[b]})),_:1}),d,Object(n["g"])(r,{to:"/login"},{default:Object(n["C"])((function(){return[p]})),_:1}),g,Object(n["g"])(r,{to:"/protected"},{default:Object(n["C"])((function(){return[O]})),_:1})]),Object(n["g"])(j)],64)}r("ecfb");const f={};f.render=j;var h=f,v=(r("45fc"),r("6c02")),m={class:"home"},y=Object(n["g"])("h5",null,"REST service call are easy to do with Vue.js, if you know how to do it.",-1),w=Object(n["g"])("p",null,null,-1),S=Object(n["g"])("h6",null,[Object(n["g"])("span",{class:"badge bg-primary"}," Let´s go!"),Object(n["f"])(" Call a Spring Boot REST backend service, by clicking a button: ")],-1),k=Object(n["g"])("p",null,null,-1),R=Object(n["f"])("API id: "),U={class:"badge bg-primary"},C=Object(n["f"])("Valid until: "),T={class:"badge bg-primary"},I=Object(n["f"])("My server time: "),N={class:"badge bg-primary"},P=Object(n["f"])("Cosmos API server time: "),x={class:"badge bg-primary"},_=Object(n["f"])("Next update: "),A={class:"badge bg-primary"};function E(e,t,r,c,s,a){return Object(n["p"])(),Object(n["d"])("div",m,[Object(n["g"])("h1",null,Object(n["y"])(e.msg),1),y,w,S,k,Object(n["g"])("button",{class:"btn btn-success",onClick:t[1]||(t[1]=function(t){return e.getServerInfo()})},"/hello (GET server data)"),Object(n["g"])("h6",null,[R,Object(n["g"])("span",U,Object(n["y"])(e.serverId),1)]),Object(n["g"])("h6",null,[C,Object(n["g"])("span",T,Object(n["y"])(e.validUntil),1)]),Object(n["g"])("h6",null,[I,Object(n["g"])("span",N,Object(n["y"])(e.serverTime),1)]),Object(n["g"])("h6",null,[P,Object(n["g"])("span",x,Object(n["y"])(e.updateTime),1)]),Object(n["g"])("h6",null,[_,Object(n["g"])("span",A,Object(n["y"])(e.nextUpdate),1)])])}var H=r("1da1"),L=(r("96cf"),r("bc3a")),B=r.n(L),D=B.a.create({baseURL:"/api",timeout:2e3,headers:{"Content-Type":"application/json"}}),F={getServerInfo:function(){return D.get("/serverinfo")},hello:function(){return D.get("/hello")},getUser:function(e){return D.get("/user/"+e)},createUser:function(e,t){return D.post("/user/"+e+"/"+t)},getSecured:function(e,t){return D.get("/secured/",{auth:{username:e,password:t}})}},V=Object(n["h"])({name:"Home",data:function(){return{showResponse:!1,serverId:"",validUntil:"",serverTime:"",updateTime:"",nextUpdate:1n,errors:[],nextUpdateInWords:""}},methods:{getServerInfo:function(){var e=this;return Object(H["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:F.getServerInfo().then((function(t){e.serverId=t.data.id,e.validUntil=t.data.validUntil,e.serverTime=t.data.serverTime,e.updateTime=t.data.updateTime,e.nextUpdate=t.data.nextUpdate}))["catch"]((function(t){e.errors.push(t)}));case 1:case"end":return t.stop()}}),t)})))()}}});V.render=E;var q=V,M=Object(n["F"])("data-v-cddfe2c0");Object(n["s"])("data-v-cddfe2c0");var J={class:"service"},Y=Object(n["g"])("h2",null,"REST service call results",-1);Object(n["q"])();var G=M((function(e,t,r,c,s,a){return Object(n["p"])(),Object(n["d"])("div",J,[Object(n["g"])("h1",null,Object(n["y"])(e.msg),1),Y,Object(n["g"])("button",{onClick:t[1]||(t[1]=function(t){return e.callHelloApi()})},"CALL Spring Boot REST backend service"),Object(n["g"])("h4",null,"Backend response: "+Object(n["y"])(e.backendResponse),1)])})),$=Object(n["h"])({name:"Service",data:function(){return{msg:"HowTo call REST-Services:",backendResponse:"",errors:[]}},methods:{callHelloApi:function(){var e=this;F.hello().then((function(t){e.backendResponse=t.data,console.log(t.data)}))["catch"]((function(t){e.errors.push(t)}))}}});r("cc6b");$.render=G,$.__scopeId="data-v-cddfe2c0";var W=$,z=Object(n["F"])("data-v-dd18674e");Object(n["s"])("data-v-dd18674e");var K={class:"bootstrap"},Q=Object(n["g"])("h5",null,"REST service call are easy to do with Vue.js, if you know how to do it.",-1),X=Object(n["g"])("p",null,null,-1),Z=Object(n["g"])("h6",null,[Object(n["g"])("span",{class:"badge bg-primary"}," Let´s go!"),Object(n["f"])(" Call a Spring Boot REST backend service, by clicking a button:")],-1),ee=Object(n["g"])("p",null,null,-1),te=Object(n["g"])("p",null,null,-1),re=Object(n["f"])("Backend response: "),ne=Object(n["g"])("button",{class:"btn btn-secondary","data-bs-toggle":"collapse","data-bs-target":"#collapseOuter"},"Show Response details",-1),ce=Object(n["g"])("p",null,null,-1),se={class:"collapse",id:"collapseOuter"},ae={class:"card card-body"},oe=Object(n["f"])(" The Response hat this details "),ue=Object(n["g"])("button",{class:"btn btn-primary","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerStatusCode"},"HTTP Status",-1),le={class:"collapse",id:"collapseInnerStatusCode"},ie={class:"card card-body"},be={class:"card card-body"},de=Object(n["g"])("button",{class:"btn btn-warning","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerHeaders"},"HTTP Headers",-1),pe={class:"collapse",id:"collapseInnerHeaders"},ge={key:0},Oe={class:"card card-body"},je=Object(n["g"])("button",{class:"btn btn-danger","data-bs-toggle":"collapse","data-bs-target":"#collapseInnerResponseConfig"},"Full Request configuration",-1),fe={class:"collapse",id:"collapseInnerResponseConfig"},he={class:"card card-body"};Object(n["q"])();var ve=z((function(e,t,r,c,s,a){return Object(n["p"])(),Object(n["d"])("div",K,[Object(n["g"])("h1",null,Object(n["y"])(e.msg),1),Q,X,Z,ee,Object(n["g"])("button",{class:"btn btn-success",onClick:t[1]||(t[1]=function(t){return e.callHelloApi()}),id:"btnCallHello"},"/hello (GET)"),te,Object(n["g"])("h4",null,[re,Object(n["g"])("span",{class:"alert alert-primary",role:"alert",show:e.showResponse,dismissible:"",onDismissed:t[2]||(t[2]=function(t){return e.showResponse=!1})},Object(n["y"])(e.backendResponse),41,["show"])]),ne,ce,Object(n["g"])("div",se,[Object(n["g"])("div",ae,[oe,ue,Object(n["g"])("div",le,[Object(n["g"])("div",ie,"Status: "+Object(n["y"])(e.httpStatusCode),1),Object(n["g"])("div",be,"Statustext: "+Object(n["y"])(e.httpStatusText),1)]),de,Object(n["g"])("div",pe,[e.headers&&e.headers.length?(Object(n["p"])(),Object(n["d"])("p",ge,[(Object(n["p"])(!0),Object(n["d"])(n["a"],null,Object(n["v"])(e.headers,(function(e){return Object(n["p"])(),Object(n["d"])("li",null,[Object(n["g"])("div",Oe,"Header: "+Object(n["y"])(e.valueOf()),1)])})),256))])):Object(n["e"])("",!0)]),je,Object(n["g"])("div",fe,[Object(n["g"])("div",he,"Config: "+Object(n["y"])(e.responseConfig),1)])])])])})),me=Object(n["h"])({name:"Bootstrap",data:function(){return{msg:"Nice Bootstrap candy!",showResponse:!1,backendResponse:"",responseConfig:"",httpStatusCode:0,httpStatusText:"",headers:["Noting here atm. Did you call the Service?"],errors:[]}},methods:{callHelloApi:function(){var e=this;F.hello().then((function(t){e.backendResponse=t.data,e.httpStatusCode=t.status,e.httpStatusText=t.statusText,e.headers=t.headers,e.responseConfig=t.config,e.showResponse=!0}))["catch"]((function(t){e.errors.push(t)}))}}});r("1c23");me.render=ve,me.__scopeId="data-v-dd18674e";var ye=me,we=Object(n["F"])("data-v-ab1c889c");Object(n["s"])("data-v-ab1c889c");var Se={class:"user"},ke=Object(n["g"])("h1",null,"Create User",-1),Re=Object(n["g"])("h3",null,"Just some database interaction...",-1),Ue={key:0},Ce={key:2};Object(n["q"])();var Te=we((function(e,t,r,c,s,a){return Object(n["p"])(),Object(n["d"])("div",Se,[ke,Re,Object(n["D"])(Object(n["g"])("input",{type:"text","onUpdate:modelValue":t[1]||(t[1]=function(t){return e.user.firstName=t}),placeholder:"first name"},null,512),[[n["A"],e.user.firstName]]),Object(n["D"])(Object(n["g"])("input",{type:"text","onUpdate:modelValue":t[2]||(t[2]=function(t){return e.user.lastName=t}),placeholder:"last name"},null,512),[[n["A"],e.user.lastName]]),Object(n["g"])("button",{onClick:t[3]||(t[3]=function(t){return e.createNewUser()})},"Create User"),e.showResponse?(Object(n["p"])(),Object(n["d"])("div",Ue,[Object(n["g"])("h6",null,"User created with Id: "+Object(n["y"])(e.user.id),1)])):Object(n["e"])("",!0),e.showResponse?(Object(n["p"])(),Object(n["d"])("button",{key:1,onClick:t[4]||(t[4]=function(t){return e.retrieveUser()})},"Retrieve user "+Object(n["y"])(e.user.id)+" data from database",1)):Object(n["e"])("",!0),e.showRetrievedUser?(Object(n["p"])(),Object(n["d"])("h4",Ce,"Retrieved User "+Object(n["y"])(e.retrievedUser.firstName)+" "+Object(n["y"])(e.retrievedUser.lastName),1)):Object(n["e"])("",!0)])})),Ie=Object(n["h"])({name:"User",data:function(){return{errors:[],user:{id:0,firstName:"",lastName:""},showResponse:!1,retrievedUser:{id:0,firstName:"",lastName:""},showRetrievedUser:!1}},methods:{createNewUser:function(){var e=this;F.createUser(this.user.firstName,this.user.lastName).then((function(t){e.user.id=t.data,console.log("Created new User with Id "+t.data),e.showResponse=!0}))["catch"]((function(t){e.errors.push(t)}))},retrieveUser:function(){var e=this;F.getUser(this.user.id).then((function(t){e.retrievedUser=t.data,e.showRetrievedUser=!0}))["catch"]((function(t){e.errors.push(t)}))}}});r("ffab");Ie.render=Te,Ie.__scopeId="data-v-ab1c889c";var Ne=Ie,Pe={key:0,class:"unprotected"},xe=Object(n["g"])("h1",null,[Object(n["g"])("span",{class:"badge bg-danger"},"You don't have rights here, mate :D")],-1),_e=Object(n["g"])("h5",null,"Seems that you don't have access rights... ",-1),Ae={key:1,class:"unprotected"},Ee=Object(n["g"])("h1",null,[Object(n["g"])("span",{class:"badge bg-warning text-dark"},"Please login to get access!")],-1),He=Object(n["g"])("h5",null,"You're not logged in - so you don't see much here. Try to log in:",-1),Le=Object(n["g"])("button",{type:"submit",class:"btn btn-primary"},"Login",-1),Be={key:0,class:"error"};function De(e,t,r,c,s,a){return e.loginError?(Object(n["p"])(),Object(n["d"])("div",Pe,[xe,_e])):(Object(n["p"])(),Object(n["d"])("div",Ae,[Ee,He,Object(n["g"])("form",{onSubmit:t[3]||(t[3]=Object(n["E"])((function(t){return e.callLogin()}),["prevent"]))},[Object(n["D"])(Object(n["g"])("input",{type:"text",placeholder:"username","onUpdate:modelValue":t[1]||(t[1]=function(t){return e.user=t})},null,512),[[n["A"],e.user]]),Object(n["D"])(Object(n["g"])("input",{type:"password",placeholder:"password","onUpdate:modelValue":t[2]||(t[2]=function(t){return e.password=t})},null,512),[[n["A"],e.password]]),Le,e.error?(Object(n["p"])(),Object(n["d"])("p",Be,"Bad login information")):Object(n["e"])("",!0)],32)]))}var Fe=Object(n["h"])({name:"Login",data:function(){return{loginError:!1,user:"",password:"",error:!1,errors:[]}},methods:{callLogin:function(){var e=this;this.errors=[],this.$store.dispatch("login",{user:this.user,password:this.password}).then((function(){e.$router.push("/Protected")}))["catch"]((function(t){e.loginError=!0,e.errors.push(t),e.error=!0}))}}});Fe.render=De;var Ve=Fe,qe=Object(n["g"])("h1",null,[Object(n["g"])("span",{class:"badge bg-success"},"YEAH you made it!")],-1),Me=Object(n["g"])("h5",null,"If you're able to read this, you've successfully logged in and redirected to this protected site :)",-1),Je=Object(n["g"])("p",null,null,-1),Ye={key:0},Ge=Object(n["g"])("span",{class:"badge bg-success"},"API call",-1),$e=Object(n["g"])("span",{class:"badge bg-success"},"successful",-1),We={key:1},ze=Object(n["g"])("span",{class:"badge bg-warning"},"API call",-1),Ke=Object(n["g"])("span",{class:"badge bg-warning"},"NOT successful",-1);function Qe(e,t,r,c,s,a){return Object(n["p"])(),Object(n["d"])("div",null,[qe,Me,Object(n["g"])("button",{class:"btn btn-primary",onClick:t[1]||(t[1]=function(t){return e.getSecuredTextFromBackend()})},"Call the secured API"),Je,e.securedApiCallSuccess?(Object(n["p"])(),Object(n["d"])("div",Ye,[Ge,Object(n["f"])(" Full response: "+Object(n["y"])(e.backendResponse)+" ",1),$e])):Object(n["e"])("",!0),e.errors?(Object(n["p"])(),Object(n["d"])("div",We,[ze,Object(n["f"])(" "+Object(n["y"])(e.errors)+" ",1),Ke])):Object(n["e"])("",!0)])}r("d3b7");var Xe=r("5502"),Ze=Object(Xe["a"])({state:{loginSuccess:!1,loginError:!1,userName:null,userPass:null},mutations:{login_success:function(e,t){e.loginSuccess=!0,e.userName=t.userName,e.userPass=t.userPass},login_error:function(e,t){e.loginError=!0,e.userName=t.userName}},actions:{login:function(e,t){var r=e.commit,n=t.user,c=t.password;return new Promise((function(e,t){console.log("Accessing backend with user: '"+n),F.getSecured(n,c).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),200==t.status&&(console.log("Login successful"),r("login_success",{userName:n,userPass:c})),e(t)}))["catch"]((function(e){console.log("Error: "+e),r("login_error",{userName:n}),t("Invalid credentials!")}))}))}},getters:{isLoggedIn:function(e){return e.loginSuccess},hasLoginErrored:function(e){return e.loginError},getUserName:function(e){return e.userName},getUserPass:function(e){return e.userPass}}}),et=Object(n["h"])({name:"Protected",data:function(){return{backendResponse:"",securedApiCallSuccess:!1,errors:[]}},methods:{getSecuredTextFromBackend:function(){var e=this;F.getSecured(Ze.getters.getUserName,Ze.getters.getUserPass).then((function(t){console.log("Response: '"+t.data+"' with Statuscode "+t.status),e.securedApiCallSuccess=!0,e.backendResponse=t.data}))["catch"]((function(t){console.log("Error: "+t),e.errors.push(t)}))}}});et.render=Qe;var tt=et,rt=[{path:"/",component:q},{path:"/callservice",component:W},{path:"/bootstrap",component:ye},{path:"/user",component:Ne},{path:"/login",component:Ve},{path:"/protected",component:tt,meta:{requiresAuth:!0}},{path:"/:pathMatch(.*)*",redirect:"/"}],nt=Object(v["a"])({history:Object(v["b"])("/"),routes:rt});nt.beforeEach((function(e,t,r){e.matched.some((function(e){return e.meta.requiresAuth}))?Ze.getters.isLoggedIn?r():r({path:"/login"}):r()}));var ct=nt;r("ab8b"),r("7b17");Object(n["c"])(h).use(ct).use(Ze).mount("#app")},cf4e:function(e,t,r){},ecfb:function(e,t,r){"use strict";r("1cd9")},f2c6:function(e,t,r){},ffab:function(e,t,r){"use strict";r("cf4e")}});
//# sourceMappingURL=app.333dac1a.js.map