(function(e){function t(t){for(var r,n,s=t[0],l=t[1],c=t[2],u=0,v=[];u<s.length;u++)n=s[u],Object.prototype.hasOwnProperty.call(o,n)&&o[n]&&v.push(o[n][0]),o[n]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(e[r]=l[r]);d&&d(t);while(v.length)v.shift()();return i.push.apply(i,c||[]),a()}function a(){for(var e,t=0;t<i.length;t++){for(var a=i[t],r=!0,n=1;n<a.length;n++){var l=a[n];0!==o[l]&&(r=!1)}r&&(i.splice(t--,1),e=s(s.s=a[0]))}return e}var r={},o={app:0},i=[];function n(e){return s.p+"static/js/"+({about:"about"}[e]||e)+"."+{about:"91336fc2"}[e]+".js"}function s(t){if(r[t])return r[t].exports;var a=r[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,s),a.l=!0,a.exports}s.e=function(e){var t=[],a=o[e];if(0!==a)if(a)t.push(a[2]);else{var r=new Promise((function(t,r){a=o[e]=[t,r]}));t.push(a[2]=r);var i,l=document.createElement("script");l.charset="utf-8",l.timeout=120,s.nc&&l.setAttribute("nonce",s.nc),l.src=n(e);var c=new Error;i=function(t){l.onerror=l.onload=null,clearTimeout(u);var a=o[e];if(0!==a){if(a){var r=t&&("load"===t.type?"missing":t.type),i=t&&t.target&&t.target.src;c.message="Loading chunk "+e+" failed.\n("+r+": "+i+")",c.name="ChunkLoadError",c.type=r,c.request=i,a[1](c)}o[e]=void 0}};var u=setTimeout((function(){i({type:"timeout",target:l})}),12e4);l.onerror=l.onload=i,document.head.appendChild(l)}return Promise.all(t)},s.m=e,s.c=r,s.d=function(e,t,a){s.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,t){if(1&t&&(e=s(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(s.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)s.d(a,r,function(t){return e[t]}.bind(null,r));return a},s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,"a",t),t},s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},s.p="/",s.oe=function(e){throw console.error(e),e};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],c=l.push.bind(l);l.push=t,l=l.slice();for(var u=0;u<l.length;u++)t(l[u]);var d=c;i.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r=a("2b0e"),o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("div",{attrs:{id:"nav"}},[a("router-link",{attrs:{to:"/"}},[e._v("Home")]),e._v(" | "),a("router-link",{attrs:{to:"/about"}},[e._v("About")])],1),a("router-view")],1)},i=[],n=(a("5c0b"),a("2877")),s={},l=Object(n["a"])(s,o,i,!1,null,null,null),c=l.exports,u=(a("d3b7"),a("3ca3"),a("ddb0"),a("8c4f")),d=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("v-app",[void 0,a("v-content",{staticClass:"container align-center px-1"},[a("h2",{staticClass:"font-weight-light mb-2"},[e._v(" COSMOS ODYSSEY ")]),a("p",[e._v("Solar System Travel Deals")]),a("v-chip",{staticClass:"ma-2",attrs:{color:"primary","x-small":"",label:"","text-color":"white"}},[e._v("API ID: "+e._s(e.items))]),a("v-chip",{staticClass:"ma-2",attrs:{color:"primary","x-small":"",label:"","text-color":"white"}},[e._v("Price list valid until:")]),a("v-card",[a("v-card-title",[e._v(" All Flights "),a("v-spacer"),a("div",[a("v-select",{attrs:{items:e.headers,label:"Select Columns",multiple:"",outlined:"","return-object":""},scopedSlots:e._u([{key:"selection",fn:function(t){var r=t.item,o=t.index;return[o<5?a("v-chip",[a("span",[e._v(e._s(r.text))])]):e._e(),5===o?a("span",{staticClass:"grey--text caption"},[e._v("(+"+e._s(e.selectedHeaders.length-2)+" others)")]):e._e()]}}]),model:{value:e.selectedHeaders,callback:function(t){e.selectedHeaders=t},expression:"selectedHeaders"}})],1)],1),a("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.showHeaders,dense:"",hover:"",items:e.items,"mobile-breakpoint":"800",inline:"",loading:e.loadTable,"loading-text":"Loading... Please wait"},scopedSlots:e._u([{key:"item.providerPrice",fn:function(t){var r=t.item;return[a("v-chip",{attrs:{color:e.getColor(r.providerPrice),dark:""}},[e._v(" "+e._s(r.providerPrice)+" ")])]}},{key:"item.actions",fn:function(t){var r=t.item;return[a("div",{staticClass:"text-truncate"},[a("v-btn",{staticClass:"mr-2",attrs:{small:"",color:"primary"},on:{click:function(t){return e.showEditDialog(r)}}},[e._v(" Book this "),a("v-icon",{attrs:{dark:"",right:""}},[e._v(" mdi-checkbox-marked-circle ")])],1)],1)]}}])},[a("v-snackbar",{scopedSlots:e._u([{key:"action",fn:function(t){var r=t.attrs;return[a("v-btn",e._b({attrs:{color:"pink",text:""},on:{click:function(t){e.snackbar=!1}}},"v-btn",r,!1),[e._v(" Close ")])]}}]),model:{value:e.snackbar,callback:function(t){e.snackbar=t},expression:"snackbar"}},[e._v(e._s(e.snackText)+" ")])],1),a("v-dialog",{attrs:{"max-width":"500px"},scopedSlots:e._u([{key:"activator",fn:function(t){var r=t.on;return[a("div",{staticClass:"d-flex"},[a("v-btn",e._g({staticClass:"ml-auto ma-3",attrs:{color:"primary",dark:""}},r),[e._v(" New "),a("v-icon",{attrs:{small:""}},[e._v("mdi-plus-circle-outline")])],1)],1)]}}]),model:{value:e.dialog,callback:function(t){e.dialog=t},expression:"dialog"}},[a("v-card",[a("v-card-title",[a("span",[e._v("Make a booking")])]),a("v-card-text",[a("v-row",[a("v-col",{attrs:{cols:"12",sm:"6"}},[a("v-text-field",{attrs:{label:"First Name"},model:{value:e.booking.firstName,callback:function(t){e.$set(e.booking,"firstName",t)},expression:"booking.firstName"}})],1),a("v-col",{attrs:{cols:"12",sm:"6"}},[a("v-text-field",{attrs:{label:"Last Name"},model:{value:e.booking.lastName,callback:function(t){e.$set(e.booking,"lastName",t)},expression:"booking.lastName"}})],1),a("v-col",{attrs:{cols:"12",sm:"12"}})],1)],1),a("v-card-actions",[a("v-spacer"),a("v-btn",{staticClass:"error",on:{click:function(t){return e.showEditDialog()}}},[e._v("Cancel")]),a("v-btn",{staticClass:"primary",on:{click:function(t){return e.saveBooking()}}},[e._v("Save")])],1)],1)],1)],1),a("v-divider"),a("v-subheader",[e._v("Last 30 bookings")]),[a("v-simple-table",{staticClass:"elevation-1",attrs:{dense:"",hover:"",loading:e.loadTable,"loading-text":"Loading... Please wait"},scopedSlots:e._u([{key:"default",fn:function(){return[a("thead",[a("tr",[a("th",{staticClass:"text-left"},[e._v(" User ID ")]),a("th",{staticClass:"text-left"},[e._v(" Booking ID ")]),a("th",{staticClass:"text-left"},[e._v(" API ID ")]),a("th",{staticClass:"text-left"},[e._v(" First Name ")]),a("th",{staticClass:"text-left"},[e._v(" Last Name ")]),a("th",{staticClass:"text-left"},[e._v(" Is in last 15 price list ")])])]),a("tbody",e._l(e.bookings,(function(t){return a("tr",{key:t.name},[a("td",[e._v(e._s(t.userId))]),a("td",[e._v(e._s(t.bookingId))]),a("td",[e._v(e._s(t.apiId))]),a("td",[e._v(e._s(t.firstName))]),a("td",[e._v(e._s(t.lastName))]),a("td",[e._v(e._s(t.isValidPrice))])])})),0)]},proxy:!0}])})]],2)],2)],1)},v=[],p=(a("4de4"),a("caad"),a("2532"),a("07ac"),a("25f0"),a("d81d"),a("bc3a")),m=a.n(p),f={name:"Home",data:function(){return{headers:[{text:"Action",value:"actions",sortable:!1},{text:"Route From Name",value:"routeFromName"},{text:"Route To Name",value:"routeToName"},{text:"Route Distance",value:"routeDistance"},{text:"Provider Price",value:"providerPrice"},{text:"Provider Flight Start",value:"providerFlightStart"},{text:"Provider Flight End",value:"providerFlightEnd"},{text:"Provider Name",value:"providerCompanyName"}],headersMap:{action:{text:"Action",value:"actions",sortable:!1},routeFromName:{text:"From",value:"routeFromName"},routeToName:{text:"Where",value:"routeToName"},routeDistance:{text:"Distance (km)",value:"routeDistance"},providerPrice:{text:"Price ($)",value:"providerPrice"},providerFlightStart:{text:"Leaves (date)",value:"providerFlightStart"},providerFlightEnd:{text:"Arrives (date)",value:"providerFlightEnd"},providerCompanyName:{text:"Provider Name",value:"providerCompanyName"}},booking:{},bookingForm:{},items:[],bookings:[],selectedHeaders:[],dialog:!1,loadTable:!0,search:"",snackbar:!1,snackText:"Booked you on flight!",routeTime:"",bookingUuid:this._uid,selectedValue1:"",selectedValue2:"",options:{Earth:[{display:"Jupiter",value:"Jupiter"},{display:"Uranus",value:"Uranus"}],Venus:[{display:"Earth",value:"Earth"},{display:"Mercury",value:"Mercury"}],Mercury:[{display:"Venus",value:"Venus"}],Mars:[{display:"Earth",value:"Earth"}],Jupiter:[{display:"Earth",value:"Earth"}],Saturn:[{display:"Neptune",value:"Neptune"},{display:"Earth",value:"Earth"}],Uranus:[{display:"Saturn",value:"Saturn"},{display:"Neptune",value:"Neptune"}],Neptune:[{display:"Mercury",value:"Mercury"},{display:"Saturn",value:"Saturn"}]}}},watch:{selectedValue1:function(e,t){e!==t&&(this.selectedValue2="")}},computed:{showHeaders:function(){var e=this;return this.headers.filter((function(t){return e.selectedHeaders.includes(t)}))}},created:function(){this.headers=Object.values(this.headersMap),this.selectedHeaders=this.headers},mounted:function(){this.loadItems()},methods:{filterFrom:function(e,t,a){return null!=e&&null!=t&&"string"===typeof e&&-1!==e.toString().indexOf(t)},getColor:function(e){return e>25e5?"red":e>1e5?"orange":"green"},showEditDialog:function(e){this.saveBooking=e||{},this.dialog=!this.dialog},loadItems:function(){var e=this;Object(p["get"])("api/serverinfo").then((function(t){e.loadTable=!1,e.apiValidUntil=t.data.apiValidUntil,e.nextUpdateAt=t.data.nextUpdateAt,e.items=t.data.map((function(e){return{id:e.id,validUntil:e.validUntil,legsId:e.legsId,routeId:e.routeId,routeFromId:e.routeFromId,routeFromName:e.routeFromName,routeToId:e.routeToId,routeToName:e.routeToName,routeDistance:e.routeDistance,providerId:e.providerId,providerPrice:e.providerPrice,providerFlightStart:e.providerFlightStart,providerFlightEnd:e.providerFlightEnd,providerCompanyId:e.providerCompanyId,providerCompanyName:e.providerCompanyName}}))})).catch((function(e){console.log(e)}))},saveBooking:function(){var e=this;Object(p["post"])("api/savebooking",{bookingId:this.bookingId}).then((function(t){e.loadTable=!0,e.saveBookingResponse=t.data})).catch((function(e){console.log(e)}))},loadBookings:function(){var e=this;Object(p["get"])("api/bookings").then((function(t){e.loadTable=!1,e.bookings=t.data.map((function(e){return{userId:e.userId,bookingId:e.bookingId,apiId:e.apiId,firstName:e.firstName,lastName:e.lastName,isValidPrice:e.isValidPrice}}))})).catch((function(e){console.log(e)}))}}},h=f,b=Object(n["a"])(h,d,v,!1,null,null,null),g=b.exports;r["default"].use(u["a"]);var k=[{path:"/",name:"Home",component:g},{path:"/about",name:"About",component:function(){return a.e("about").then(a.bind(null,"f820"))}}],y=new u["a"]({mode:"history",base:"/",routes:k}),_=y,x=a("2106"),N=a.n(x),C=a("ce5b"),I=a.n(C);a("bf40");r["default"].use(I.a);var P=new I.a({theme:{dark:!1}});r["default"].use(I.a),r["default"].use(N.a,m.a),r["default"].config.productionTip=!1,new r["default"]({router:_,vuetify:P,render:function(e){return e(c)}}).$mount("#app")},"5c0b":function(e,t,a){"use strict";a("9c0c")},"9c0c":function(e,t,a){}});
//# sourceMappingURL=app.2f0814c1.js.map