window.onload=function() {
    var mapData={
        layer:[{id:0,name:"动物",type:"resource",beginType:"资源展示",showIf:true,showDetail:[],showSymbol:"AnimalName",filterShow:[],filterShowCopy:[],deleteUrl:"updateAnimal/SPID/PatrolSubId"},
            {id:1,name:"植物",type:"resource",showIf:false,showDetail:[],showSymbol:"BotanyName",filterShow:[],filterShowCopy:[],deleteUrl:"updateAnimal/SPID/PatrolSubId"},
            {id:2,name:"牌栏",type:"resource",showIf:false,showDetail:[],showSymbol:"BrandName",filterShow:[],filterShowCopy:[],deleteUrl:"strikeOutBrand/BrandID"},
            {id:3,name:"生境点",type:"resource",showIf:false,showDetail:[],showSymbol:"SPID",filterShow:[],filterShowCopy:[],deleteUrl:"deleteSpreadRelation/SPID/PatrolId"},
            {id:4,name:"红外相机",type:"resource",showIf:false,showDetail:[],showSymbol:"SPID",filterShow:[],filterShowCopy:[]},
            {id:5,name:"界碑",type:"resource",showIf:false,showDetail:[],showSymbol:"BoundaryNa",filterShow:[],filterShowCopy:[],deleteUrl:"strikeOutBoundary/BoundaryID"},
            {id:6,name:"人为干扰",type:"monitor",beginType:"监测展示",showIf:false,showDetail:[],showSymbol:"SPID",filterShow:[],filterShowCopy:[],deleteUrl:"deleteModification/SPID/PatrolId"},
            {id:7,name:"灾害监测",type:"monitor",showIf:false,showDetail:[],showSymbol:"DisasterNa",filterShow:[],filterShowCopy:[],deleteUrl:"deleteXhDisaster/SPID/PatrolId"},
            {id:8,name:"视频监控",type:"monitor",showIf:false,showDetail:[],showSymbol:"CameraName",filterShow:[],filterShowCopy:[],deleteUrl:"strikeOutCamera/CameraId"},
            {id:9,name:"巡护路线",type:"monitor",showIf:false,showDetail:[],showSymbol:"LINENAME",filterShow:[],filterShowCopy:[]},
            {id:10,name:"样地",type:"monitor",showIf:false,showDetail:[],showSymbol:"QuadratD_1",filterShow:[],filterShowCopy:[]}],
             nowShow:"resource",
             fieldShow:[[["AnimalName","动物"],["SPID","SPID"],["PatrolSubI","PatrolSubId"],["AnimalCode","动物代码"],["PatrolId","PatrolId"],["NativeCode","NativeCode"],["OBJECTID","OBJECTID"]],
                        [["BotanyName","植物"],["SPID","SPID"],["PatrolSubI","PatrolSubId"],["BotanyCode","植物代码"],["OBJECTID","OBJECTID"]],
                        [["BrandName","牌栏"],["BrandID","BrandID"],["OBJECTID","OBJECTID"]],[["OBJECTID","生境点"],["SPID","SPID"],["PatrolId","PatrolId"],["OBJECTID","OBJECTID"]],[["SPID","id"]],  [["BoundaryNa","界碑"],["BoundaryID","BoundaryID"],["OBJECTID","OBJECTID"]],
                        [["PeopleActi","人为干扰"],["SPID","SPID"],["PatrolId","PatrolId"],["OBJECTID","OBJECTID"]],[["DisasterNa","灾害监测"],["SPID","SPID"],["PatrolId","PatrolId"],["OBJECTID","OBJECTID"]],
                        [["CameraName","视频监控"],["CameraId","CameraId"],["OBJECTID","OBJECTID"]], [["LINENAME","线路"]],[["QuadratDat","样地代码"],["QuadratID","样地ID"]] ],
            showDetailClass:"detailname"
    };
    // 公共功能函数
    // get drop select data
    var getDropData=function(dataUrl,target){
        var i;
        var dropData=$.get(dataUrl,function(data){
            var JsonData=JSON.parse(data).data;
            for(item in JsonData){
                for(i=0;i<JsonData[item].length;i++){
                    target[item].push(JsonData[item][i])
                }
            }
        })
    }
    var makesTring=function(target){
        var type=typeof(target);
        console.log(type);
        if(type=="string"){
            var mat=new RegExp("([a-z]|[A-Z]|-|[0-9])");
            for(var i=0;i<target.length;i++){
                if(mat.test(target[i])==false){
                    target=target.slice(1);
                    break;
                };
            }
            return target;
        }
    }
    var showMap=new Vue({
        el:"#controll",
        data:mapData,
        methods:{
            test:function(){
            }
        }
    });
    var lineData={
        line:[],simulate:{}
    }
    var showLine=new Vue({
        el:"#lineSection",
        data:lineData,
        methods:{
            simulatePatrol:function(e){
                 var patrol=e.target.getAttribute("data-path");
                 this.simulate(this.line[patrol].path,patrol);
            }
        }
    })
    var measureData={twoPoint:[],linePoint:[],areaPoint:[],twoPointResult:"",linePointResult:"",areaPointResult:""}
    var measureAction=new Vue({
        el:"#measureSection",
        data:measureData,
    })
    var toolData={location:[],addLng:"",addLat:""}
    var toolSection=new Vue({
        el:"#tools",
        data:toolData
    })
    var animalPopupMsg={
        msg:"test",
        msgAttributes:{animalCode:"",animalKey:"",animalName:"",door:"",protectTypeName:"",collectionDate:"",collectionPerson:"",
            door_C:"",englishName:"",family_C:"",genus:"",latinName:"",species:"",kidName:"",remark:"",gand_C:"",orders_C:"",
            genus_C:""},
        msgMonitor:{SPID:"",action:"",altitude:"",diatance:"",animalCode:"",animalName:"",habitatId:"",lat:"",lng:"",monitorAddress:"",monitorTime:"",traceType:"",weatherId:"",terrain:"",
            findContent:"",traceTime:"",patrolLineId:"",patrolLineName:"",patrolSubId:""
        },
        Action:[], TraceType:[], TraceTime:[]
    }
    // 获取动物的行为和痕迹下拉框
    getDropData("/queryActionTraceTimeIfon/",animalPopupMsg);
    var animalPopMsg=new Vue({
        el:"#animal-popMsg",
        data:animalPopupMsg,
        methods:{
            getHabitatMsg:function(){
            }
        }
    })
    var animalNum={
        young:{MaleQty:"",FemaleQty:"",TotalQty:""},
        adult:{MaleQty:"",FemaleQty:"",TotalQty:""},
        old:{MaleQty:"",FemaleQty:"",TotalQty:""},
        trace:{MaleQty:"",FemaleQty:"",TotalQty:""},
        body:{MaleQty:"",FemaleQty:"",TotalQty:""},
    }
    var animalNumber=new Vue({
        el:"#animal-number",
        data:animalNum
    })
    var plantPopupMsg={
        msg:"test",
        msgAttributes:{animalCode:"",animalKey:"",animalName:"",door:"",protectTypeName:"",animalName:"",collectionDate:"",collectionPerson:"",
            door_C:"",englishName:"",family_C:"",genus:"",latinName:"",species:"",kidName:"",latinName:"",remark:"",gand_C:"",orders_C:"",
            genus_C:"",species:"",englishName:""},
        msgMonitor:{SPID:"",altitude:"",botanyCode:"",botanyName:"",coverDegree:"",coverType:"",findContent:"",
            firstFz:"",growthSort:"",guanFu:"",habitatId:"",healthStatus:"",height:"",lng:"",lat:"",locationId:"",
            monitorAddress:"",monitorTime:"",patrolLineId:"",patrolLineName:"",patrolSubId:"",phenological:"",plantType:"",qty:"",xiongJing:"",slopeId:"",terrain:""
        },
        GrowthSort:[], HealthStatus:[], Phenological:[],
    }
    //获取植物生长类型 物候期 健康状况下拉列表
    getDropData("/plantInformation",plantPopupMsg);
    var plantPopMsg=new Vue({
        el:"#plant-popMsg",
        data:plantPopupMsg
    })
    var brandPopupMsg={
        msg:{BHQID:"",bioImageId:"",brandID:"",brandName:"",content:"",createdBy:"",
        creationDate:"",lastUpdateDate:"",lastUpdatedBy:"",lat:"",lng:"",
        locationName:"",model:"",nativeCode:"",personLiable:"",publishdate:"",publisher:"",
        qty:"",sizes:"",sortName:""},
    }
    var brandPopMsg=new Vue({
        el:"#brand-popMsg",
        data:brandPopupMsg
    })

    var boundaryPopupMsg={
        msg:{BHQID:"",bioImageId:"",boundaryID:"",boundaryName:"",content:"",
        createdBy:"",creationDate:"",lastUpdateDate:"",lastUpdatedBy:"",lat:"",lng:"",
        locationName:"",nativeCode:"",publishdate:""}
    }
    var boundaryPopMsg=new Vue({
           el:"#boundary-popMsg",
           data:boundaryPopupMsg
  })
    var manTroblePopupMsg={
        msg:{SPID:"",patrolId:"",altitude:"",findContent:"",interfereStrg:"",interfereTime:"",interfereType:"",lat:"28.2035134",law:"",lng:"112.979382",
            monitorAddress:"y",monitorTime:"",patrolLineId:"",patrolLineName:"",
            punishResult:"",qty:""},
        InterfereTime:[],InterfereType:[],InterfereStrg:[],Law:[]
    }
  getDropData("/selectXhPeopleAction",manTroblePopupMsg);    // get drop select data
    var mantroublePopMsg=new Vue({
        el:"#trouble-popMsg",
        data:manTroblePopupMsg
    })

    var habitatPopupMsg={
        msg:{SPID:"",altitude:"",coverColloid:"",coverPorosity:"",coverStructural:"",covertType:"",
        habitatId:"",lat:"",lng:"",locationId:"",patrolId:"",plantType:"",slopeId:"",terrain:""},
        PlantType:[],HabitatId:[],Terrain:[],CovertType:[],CoverPorosity:[],CoverStructural:[],CoverColloid:[],SlopeId:[]
    }

   getDropData("/selectsJYZ",habitatPopupMsg);  // get drop select data
    var habitatPopMsg=new Vue({
        el:"#habitat-popMsg",
        data:habitatPopupMsg
    })

    var cameraPopupMsg={
        msg:{cameraId:"",cameraName:"",provinceid:"",cityid:"",countryID:"",installPos:"",deptId:"",installTime:"",runState:"",factory:"",serialNo:"",
            ipAddress:"",userName:"",userPw:"",port:"",channel:"",orderBy:"",type:"",serverName:"",lat:"",lng:"",CDID:"",cameraStadia:"",
            cameraVariation:"",headVariation:"",isVisible:"",comIPAddress:"",vVariation:"",isJdhc:"",serverIPAddress:"",serverPort:"",nativeCode:"",
            rtspPort:""
        },
        RunState:[],Factory:[],type:[]
    }
    getDropData("/dropCamera",cameraPopupMsg);
    var cameraPopMsg=new Vue({
        el:"#camera-popMsg",
        data:cameraPopupMsg
    })

     var disasterPopupMsg={
        msg:{MArea:"",SPID:"",altitude:"",disasterDegree:"",disasterTime:"",disasterType:"",findContent:"",lat:"",lng:"",monitorAddress:"",
            monitorTime:"",patrolId:"",patrolLineId:"",patrolLineName:""},
       disasterDegree:[],disasterType:[],disasterTime:[]
     }
     getDropData("/selectXhDisaster",disasterPopupMsg);
     var disasterPopMsg=new Vue({
         el:"#disaster-popMsg",
         data:disasterPopupMsg
     })

    var quadratPopupMsg={
         msg:{isid:"",quadratid:"",nativecode:"",quadratdatacode:"",quadratdataname:"",lat:"",lng:"",gradient:"",
             aspect:"",altitude:"",area:"",address:"",soilcode:"",humusspy:"",invester:"",investerdate:"",createdby:"",
             creationdate:"",lastupdatedby:"",lastupdatedate:""},
        soilCode:[]
    }
    $.get("/droQuadratDataurl",function(data){
         var dropMsg=JSON.parse(data).data;
         for(var i=0;i<dropMsg.length;i++){
             quadratPopupMsg.soilCode.push(dropMsg[i])
         }
    })
    var quadraPopMsg=new Vue({
        el:"#quatrat-popMsg",
        data:quadratPopupMsg
    })
    //feature add or updata status
    var featureOpration={
        add:false
    }
    var userLogin=$("#userStatus").val();

    $("#userStatus").change(function(){
         userLogin=$(this).val();
         console.log(userLogin);
    })

    var layerUiIndex;
//--------注释：----------------菜单栏切换展示---------------
    document.getElementById("resource").onclick=function(){
        mapData.nowShow="resource";
    };
    document.getElementById("monitor").onclick=function(){
        mapData.nowShow="monitor";
    };
       var childMenu=document.getElementsByClassName("childMenu")[0].children;
    var menuStatus;
    for(var i =0;i < childMenu.length;i++){
        childMenu[i].onclick = (function index(x){
            return function(){
                var menuToggle=document.getElementsByClassName("controll");

                var t;
                for(t=0;t<menuToggle.length;t++){
                    childMenu[t].className="";
                    menuToggle[t].style.display="none";
                }
                menuStatus=x;
                menuToggle[x].style.display="block";
                childMenu[x].className="childMenuActive";
            }
        })(i)
    }
        document.getElementById("lineShow").onclick=function(){
        var eventType=this.getAttribute("data-controllShow");

        if(eventType=="false") {
            layui.use('table', function () {
                var table = layui.table;
                //第一个实例
                table.render({
                    elem: '#lineList'
                    , height: 315
                    , width: 900
                    , url: '/contrailInfo' //数据接口
                    , page: false//开启分页
                    , cols: [[ //表头
                        {field: 'patrolId', title: 'ID', width: 80, sort: true, fixed: 'left'}
                        , {field: 'userName', title: '用户名', sort: true, width: 110}
                        , {field: 'beginTime', title: '开始时间', width: 130, sort: true}
                        , {field: 'endTime', title: '结束时间', width: 130}
                        , {field: 'patrolPlanName', title: '线路名称', width: 177}
                        , {field: 'pointCount', title: '点的个数', width: 120, sort: true}
                        , {fixed: 'right', width: 150, align: 'center', toolbar: '#barLineList'}
                    ]]
                });
            });
            this.setAttribute("data-controllShow",true);
        }
        else{
             var elementControll=document.getElementsByClassName("lineLiatContain")[0];
             if(elementControll.style.display=="block"){
                 elementControll.style.display="none";
             }
             else {
                 elementControll.style.display="block";
             }
        }
        }
        var table=layui.table;
        var measureStatus="measureTwoPoint";
    //-------注释：------------------测量工具切换样式切换---------------
            $(".measureMenu").click(function(){
                if($(this).hasClass("layui-btn-primary")){
                    $(this).removeClass("layui-btn-primary");
                }
                measureStatus=$(this).attr("data-active");
                $(this).siblings().addClass("layui-btn-primary");

    })
    //-------注释：------------------测量两点间距离---------------
         var measureTwoPoint=function(p1,p2){
    // 返回 p1 到 p2 间的地面距离，单位：米
             var dis = AMap.GeometryUtil.distance(p1, p2);
             return dis;
         }
//------注释：-------------------地图展示---------------
    require([
            "esri/Map",
            "esri/views/MapView",
            "esri/views/SceneView",
            "esri/Graphic",
            "esri/layers/FeatureLayer",
            "dojo/query",
            "esri/geometry/Extent",
            "esri/geometry/Geometry",
            "esri/layers/support/LabelClass",
            "esri/widgets/CoordinateConversion",
            "dojo/domReady!",
        ],
        function (
            Map, MapView,SceneView, Graphic,
            FeatureLayer,query,Extent,Geometry,LabelClass,CoordinateConversion
        ) {

            var map = new Map(
               {basemap:"satellite",showLabels : true}
            );
            var view = new MapView({
                container: "viewDiv",
                map: map,
                highlightOptions: {
                    color: [255, 241, 58],
                    fillOpacity: 0.4
                },
                 extent: { // autocasts as new Extent()
                    xmin: 112.926173371,
                    ymin: 28.161690171000032,
                    xmax: 113.02622340000005,
                    ymax: 28.244196035000073,
                    spatialReference: 4326
                },
                environment: {
                    atmosphereEnabled: true,
                    atmosphere: {
                        quality: "high"
                    } }
            });
            var ccWidget = new CoordinateConversion({
                view: view
            });
            view.ui.add(ccWidget, "bottom-left");
//-------注释：------------------2D 3D切换---------------
            var toggle2D=document.getElementById("toggle2D");
            var toggle3D=document.getElementById("toggle3D");
            var toggle2DStatus=true;
            var toggle3DStatus=false;
            toggle3D.onclick=function(){
                if(toggle3DStatus==true){return}
                view=null;
               view = new SceneView({
                    container: "viewDiv",
                    map: map,

                    extent: { // autocasts as new Extent()
                        xmin: 112.926173371,
                        ymin: 28.161690171000032,
                        xmax: 113.02622340000005,
                        ymax: 28.244196035000073,
                        spatialReference: 4326
                    }
                });
//-------注释：------------------view界面部件添加 位置移动---------------
                view.ui.add(menuOpen, "top-left");
                view.ui.move("zoom", "top-right");
                view.ui.move("navigation-toggle", "top-right");
                view.ui.move("compass", "top-right");
                view.ui.add(ccWidget, "bottom-right");
                toggle3DStatus=true;
                toggle2DStatus=false;
            }
            toggle2D.onclick=function(){
                if(toggle2DStatus==true){return}
                view=null;
                view = new MapView({
                    container: "viewDiv",
                    map: map,

                    extent: { // autocasts as new Extent()
                        xmin: 112.926173371,
                        ymin: 28.161690171000032,
                        xmax: 113.02622340000005,
                        ymax: 28.244196035000073,
                        spatialReference: 4326
                    }
                });
                view.ui.add(menuOpen, "top-left");
                view.ui.move("zoom", "top-right");
                toggle3DStatus=false;
                toggle2DStatus=true;
            }
//------------------------弹出信息模板---------------
            var template = {
                title: "this is just one test",
                content: [{
                    type: "fields",
                    fieldInfos: [{
                        fieldName: "功能区划",
                        label: "功能区划",
                        visible: true
                    }]
                }]
            };
            var menuOpen=document.getElementById("menContain");
            var menuDetail=document.getElementById("menuSection");
            var menuActive=document.getElementsByClassName("menu-symbol")[0]
            view.ui.add(menuOpen, "top-left");
            view.ui.add(ccWidget, "bottom-right");
            view.ui.move("toggle", "top-right");
            view.ui.move("zoom", "top-right");
            menuDetail.style.display="none"
            menuActive.onclick=function(){

                 if(menuDetail.style.display=="none"){menuDetail.style.display="block"}
                 else{menuDetail.style.display="none"}
            }
            // Carbon storage of trees in Warren Wilson College.
//-------注释：------------------加载基本图层---------------
            var featureLayer = new FeatureLayer({
                url: "http://192.168.0.241:6080/arcgis/rest/services/BHQBaseData/FeatureServer/11",
                outFields: ["*"],
                popupTemplate: template
            });
            map.add(featureLayer);
//-------注释：------------------弹出信息 循环获取存入数组--------------
            var layerChoose=query(".testCheckedBox")
            var i;
            var times;var timesChild;
            var layerArray=[];
            var templateArray=[];
            var status=new Array();
            for(times=0;times<mapData.fieldShow.length;times++){
                var templateChildArray=[];
                 for(timesChild=0;timesChild<mapData.fieldShow[times].length;timesChild++){
                     templateChildArray.push({fieldName:mapData.fieldShow[times][timesChild][0],label:mapData.fieldShow[times][timesChild][1]})
                 }
                var zoomOutAction = {
                    // This text is displayed as a tooltip
                    title: "详细信息",
                    // The ID by which to reference the action in the event handler
                    id: "popup-detatl-msg",
                    // Sets the icon font used to style the action button
                    className: "esri-icon-cta-link-external datail-click"
                };
                var deleteAction = {
                    // This text is displayed as a tooltip
                    title: "删除此条记录",
                    // The ID by which to reference the action in the event handler
                    id: "popup-delete-msg",
                    // Sets the icon font used to style the action button
                    className: "esri-icon-close"
                };

                 var template={
                     title: "信息展示如下",
                     content: [{
                         type: "fields",
                         fieldInfos: templateChildArray
                     }],
                     actions:[zoomOutAction,deleteAction]
                 };

                templateArray.push(template);
            }
  //-------注释：------------------给每个种类通过SQL语句添加点击隐藏 显示事件--------------
                var feature=function(nameList,whichLayer){
                     return function () {
                         var queryString=".detail-table input[layerid='"+whichLayer+"']";
                         var allChildChoose = query(queryString);
                         for (i = 0; i < allChildChoose.length; i++) {
                             allChildChoose[i].onclick = function () {
                                 var id=this.getAttribute("layerId");
                                 var name=this.value;
                                 var nowNameList=nameList||mapData.layer[id].fieldShow;
                                 if(this.checked==true) {
                                     if(nowNameList.indexOf(name)==-1){nowNameList.push(name)}
                                 }
                                 else {
                                     if(nowNameList.indexOf(name)>-1){
                                         var index=nowNameList.indexOf(name);
                                         nowNameList.splice(index,1);
                                     }
                                 }
                                 var sqlScope=new Array;
                                 for(i=0;i<nowNameList.length;i++){
                                     sqlScope.push("'"+nowNameList[i]+"'")
                                 };
                                 if(sqlScope.length>0){
                                     status[id]=mapData.layer[id].showSymbol+" "+"in ("+sqlScope+")";
                                     if(layerArray[id].definitionExpression){
                                         if(layerArray[id].definitionExpression.indexOf("and"))
                                             layerArray[id].definitionExpression=mapData.layer[id].showSymbol+" "+"in ("+sqlScope+")"+" and "+layerArray[id].definitionExpression.split("and")[1];
                                         else layerArray[id].definitionExpression=mapData.layer[id].showSymbol+" "+"in ("+sqlScope+")"+"and NativeCode=40000";
                                     }
                                     else{layerArray[id].definitionExpression=mapData.layer[id].showSymbol+" "+"in ("+sqlScope+")"+"and NativeCode=40000";}
                                 }
                                 else{
                                     if(layerArray[id].definitionExpression){
                                         if(layerArray[id].definitionExpression.indexOf("and"))
                                             layerArray[id].definitionExpression="OBJECTID=-100"+" and "+layerArray[id].definitionExpression.split("and")[1];
                                         else layerArray[id].definitionExpression="OBJECTID=-100 and NativeCode=40000";
                                     }
                                     else{layerArray[id].definitionExpression="OBJECTID=-100 and NativeCode=40000"}
                                 }
                                 console.log(layerArray[id].definitionExpression);
                             }
                         }
                     }
                }
 //-------注释：------------------指定保护区展示--------------

                          $("#selectProtect").change(function(){
                              var protectAreaCode=this.value;
                              var lng=$("#selectProtect option:selected").attr("data-center-lng");
                              var lat=$("#selectProtect option:selected").attr("data-center-lat");
                              console.log(lng+lat);
                              if(lng){
                                  var point=new Array();
                                  point.push(lng*1);
                                  point.push(lat*1);
                                  view.center=point;
                              }
                              for(var i=0;i<layerArray.length;i++){
                                  if(layerArray[i].definitionExpression) {
                                      if(layerArray[i].definitionExpression.indexOf("and")==-1)layerArray[i].definitionExpression=layerArray[i].definitionExpression+'and NativeCode'+protectAreaCode;
                                      else{
                                          layerArray[i].definitionExpression=layerArray[i].definitionExpression.split("and")[0]+'and NativeCode'+protectAreaCode;
                                      }
                                  }
                                  else layerArray[i].definitionExpression='OBJECTID>-1'+'and NativeCode'+protectAreaCode;
                              }

                          })
 //-------注释：------------------给每个种类添加定位事件--------------
            var kindLocation=function(x,y){
                var centerLoction=new Array();
                centerLoction[0]=x;
                centerLoction[1]=y;
                view.center=centerLoction;
            }
            var addKindClick=function(){
                var kind=document.getElementsByClassName("showDetailClass");
                var i;
                for(i=0;i<kind.length;i++){
                    kind[i].onclick=function(){
                        var x=this.getAttribute("x");
                        var y=this.getAttribute("y");
                        kindLocation(x,y);
                    };
                }
            }
//-------注释：------------------循环获取图层 并存入数组 加上相应移除 载入 展示信息事件---------------
            var serverAddress="http://192.168.0.241:6080/arcgis/rest/services/BHQBaseData/FeatureServer/";
            // 每个图层的点击事件
            for(i=0;i<layerChoose.length;i++) {
                layerArray.push(new FeatureLayer({url:serverAddress+i,outFields: ["*"],popupTemplate: templateArray[i],labelsVisible:true,
                }));
                map.add(layerArray[i]);
                layerArray[i].visible=false;
                layerChoose[i].onclick = function () {
                   this.checked=!this.checked;
                     var num=this.getAttribute("data");
                     var all=query("input[ifAllChoose]")[num];
                     all.checked=this.checked;
                    if(this.checked==true) {
                        var layerExtent=layerArray[num].fullExtent;
                        var targetScope=new Extent();var xArray=new Array(); var yArray=new Array();
                        var nameList=new Array();
                        mapData.layer[num].showIf=true;
                        layerArray[num].visible=true;
                       if(status[num]) layerArray[num].definitionExpression=status[num];
                        all.disabled=false;
                        // 注释：  载入图层时，信息初始化。
                        if(!mapData.layer[num].showDetail.length>0){

                        layerArray[num].queryFeatures().then(function(results){
                            var count;
                            for(count=0;count<results.features.length;count++){
                                //获取每个图层的extent----------------------------------------
                             if(results.features[count].geometry.extent){
                                 xArray.push(results.features[count].geometry.extent.center.x);
                                 yArray.push(results.features[count].geometry.extent.center.y);
                             }
                             else{
                                 xArray.push((results.features[count].geometry.x));
                                 yArray.push((results.features[count].geometry.y));
                             }
                                targetScope.xmin=xArray.sort()[xArray.length-1];
                                targetScope.xmax=xArray.sort()[0];
                                targetScope.ymin=yArray.sort()[yArray.length-1];
                                targetScope.ymax=yArray.sort()[0];
                                targetScope.spatialReference=4326;

                                //获取每个要素的信息-----------------------------------------------
                                var eg={};
                                eg.id=results.features[count].attributes.OBJECTID;
                                var field=mapData.layer[num].showSymbol;
                                eg.name=results.features[count].attributes[field];

                                // ----注释--------------------设置同一种类只显示一个
                                eg.visibility=true;
                              if(nameList.indexOf(eg.name)>-1){eg.visibility=false;}
                              else{nameList.push(eg.name)}
                                eg.latitude=results.features[count].geometry.x||results.features[count].geometry.extent.center.x;
                                eg.longitude=results.features[count].geometry.y||results.features[count].geometry.extent.center.y;
                                mapData.layer[num].showDetail.push(eg);
                            }
                            mapData.layer[num].viewScope=targetScope;
                            mapData.layer[num].fieldShow=nameList;
                            mapData.layer[num].filterShowCopy=nameList;

                        })
                        setTimeout(addKindClick,500);
                        setTimeout(feature(null,num),300);  }
                    }
                   else{
                        // 关闭图层时相应操作---------------------------
                        layerArray[num].visible=false;
                        all.disabled=true;
                        mapData.layer[num].showIf=false;
                        status[num]=layerArray[num].definitionExpression;
                    }
                }
                //双击图层定位
         /*    layerChoose[i].ondblclick=function(){

                    var num=this.getAttribute("data");
                    if(mapData.layer[num].viewScope){
                        view.extent=mapData.layer[num].viewScope;
                        view.zoom=13;
                    }
                }  */
            }
            // 显示各图层的要素详细信息
            view.popup.on("trigger-action", function(event){
                // If the zoom-out action is clicked, fire the zoomOut() function
                if(event.action.id === "popup-detatl-msg") {
                    console.log("detail");
                    $(".msgPopup").find("[name]").attr("disabled","disabled");
                    var whichLayer = $(".esri-feature__field-header")[0].innerText;
                    var popupGetOption = $(".esri-feature__field-data");
                    if(popupGetOption[1]) var spid = makesTring(popupGetOption[1].innerText);
                    if(popupGetOption[2]) var subid = makesTring(popupGetOption[2].innerText);
                    if(popupGetOption[3])var animolCode = makesTring(popupGetOption[3].innerText);
                    if (whichLayer == "动物") {
                        var urlTranslate = "/selectinFormation/" + spid + "/" + subid;
                        var url = "/getSpreadSubInfo/" + spid + "/" + subid;
                        var urlAnimalAttribute = "/selectBeast/" + animolCode;
                          $.get(urlTranslate, function (data) {
                            var animalAttributes;
                            $.get(urlAnimalAttribute, function (data) {
                                animalAttributes = JSON.parse(data).data[0];
                                for (item in animalPopupMsg.msgAttributes) {
                                    if(animalAttributes[item])animalPopupMsg.msgAttributes[item] = animalAttributes[item];
                                }
                            })
                            var codeTranslate = JSON.parse(data).data;
                            $.get(url, function (data) {
                                console.log("time:"+animalPopupMsg.dropTraceTime);
                                var msgData = JSON.parse(data).data.patrolFindInfoSub[0];
                                console.log(msgData);
                                for (item in animalPopupMsg.msgMonitor) {
                                    animalPopupMsg.msgMonitor[item] = msgData[item];
                                }

                                layer.open({
                                    type: 1,
                                    title: false,
                                    closeBtn: 0,
                                    shadeClose: true,
                                    skin: 'yourclass',
                                    content: $("#animal-popMsg")
                                });

                                //动物修改后保存按钮
                                $("#animalPopupSave").unbind("click").click(function(){
                                    if(!(userLogin=="superUser")) {alert("只有超级用户才能修改信息");return}
                                    var msgChanged=$(this).parent().prev().find("[name]");
                                    for(var i=0;i<msgChanged.length;i++){
                                       if(msgChanged[i].getAttribute("name")) msgData[msgChanged[i].getAttribute("name")]=msgChanged[i].value;
                                       for(item in dropMsg){
                                           if(msgChanged[i].getAttribute("name").toLowerCase()==item.toLowerCase()){

                                               for(var ii=0;ii<dropMsg[item].length;ii++){
                                                   if(dropMsg[item][ii].name==msgChanged[i].value) msgData[msgChanged[i].getAttribute("name")]=dropMsg[item][ii].id*1
                                               }
                                           }
                                       }
                                    }
                                    // updata feature
                                    msgData.patrolSubId=subid;
                                    var urlForChange="/updateAnimalIfon/"+JSON.stringify(msgData);
                                    $.get(urlForChange,function (data) {
                                 })
                                    // add feature

                                    $(".msgPopup").find("[name]").attr("disabled","disabled");
                                })
                            })
                            $("#showNumberMsg").unbind("click").click(function () {
                                var url="/animalNumber/"+spid+"/"+subid;
                                $.get(url, function (data) {
                                    var msg = JSON.parse(data).data;
                                    for (var i = 0;i < msg.length;i++) {
                                        if (msg[i].GrowthState == 2301) {
                                            animalNum.young.MaleQty = msg[i].MaleQty;
                                            animalNum.young.FemaleQty = msg[i].FemaleQty;
                                            animalNum.young.TotalQty = msg[i].TotalQty;
                                        }
                                        if (msg[i].GrowthState == 2302) {
                                            animalNum.adult.MaleQty = msg[i].MaleQty;
                                            animalNum.adult.FemaleQty = msg[i].FemaleQty;
                                            animalNum.adult.TotalQty = msg[i].TotalQty;
                                        }
                                        if (msg[i].GrowthState == 2303) {
                                            animalNum.old.MaleQty = msg[i].MaleQty;
                                            animalNum.old.FemaleQty = msg[i].FemaleQty;
                                            animalNum.old.TotalQty = msg[i].TotalQty;
                                        }
                                        if (msg[i].GrowthState == 2304) {
                                            animalNum.trace.MaleQty = msg[i].MaleQty;
                                            animalNum.trace.FemaleQty = msg[i].FemaleQty;
                                            animalNum.trace.TotalQty = msg[i].TotalQty;
                                        }
                                        if (msg[i].GrowthState == 2305) {
                                            animalNum.body.MaleQty = msg[i].MaleQty;
                                            animalNum.body.FemaleQty = msg[i].FemaleQty;
                                            animalNum.body.TotalQty = msg[i].TotalQty;
                                        }
                                    }
                                    layer.open({
                                        type: 1,
                                        content: $('#animal-number') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                    });
                                })
                            })
                        })
                    }
                     if(whichLayer=="植物"){
                        var urlTranslate = "/selectinFormation/" + spid + "/" + subid;
                        var url = "/queryBySpreadSubifon/" + spid + "/" + subid;
                        var urlPlantAttribute = "/queryPlant/" + animolCode;
                        $.get(urlPlantAttribute,function(data){
                            var plantAttributes = JSON.parse(data).data[0];
                           if(JSON.parse(data).data.length>0) {
                               for (item in plantPopupMsg.msgAttributes) {
                                   plantPopupMsg.msgAttributes[item] = plantAttributes[item];
                               }
                           }
                        })
                        $.get(urlTranslate,function(data){
                            var translatMsg=JSON.parse(data).data;
                            $.get(url,function(data){
                                  var plantMsg=JSON.parse(data).data[0];
                                   console.log(plantMsg);
                                  if(JSON.parse(data).data.length>0) {
                                 //     for (item in plantMsg) {
                                 //         if (translatMsg[plantMsg[item]]) plantMsg[item] = translatMsg[plantMsg[item]];
                                 //     }
                                      for (item in plantPopupMsg.msgMonitor) {
                                          plantPopupMsg.msgMonitor[item] = plantMsg[item];
                                      }
                                  }
                                // 植物修改保存按钮 增加植物要素
                                $("#plantPopupSave").unbind("click").click(function () {
                                    if(!(userLogin=="superUser")) {alert("只有超级用户才能修改信息");return}
                                        var urlForUpdata = "/updatePlantIfonUrl/" + JSON.stringify(plantPopupMsg.msgMonitor);
                                        $.get(urlForUpdata, function (data) {
                                            console.log(data);
                                        });
                                })
                                layer.open({
                                    type: 1,
                                    title: false,
                                    closeBtn: 0,
                                    shadeClose: true,
                                    skin: 'yourclass',
                                    content: $("#plant-popMsg"),
                                })
                            })
                        })
                     }
                     if(whichLayer=="牌栏"){
                            var url="/selectStone/"+spid;
                            for(item in brandPopupMsg.msg){
                                brandPopupMsg.msg[item]="";
                            }
                            $.get(url,function(data){
                                if(JSON.parse(data).data.length>0) {
                                    var msg = JSON.parse(data).data[0];
                                    for (item in brandPopupMsg.msg) {
                                        brandPopupMsg.msg[item] = msg[item];
                                    }
                                }
                                $("#brandPopupSave").unbind("click").click(function(event){

                                    var changedMsg=brandPopupMsg.msg;
                                    changedMsg.brandID=spid;
                                    var urlForChange="/updateBrandUrl/"+JSON.stringify(changedMsg);
                                    console.log(urlForChange);
                                    $.get(urlForChange,function(data){
                                        console.log(data);
                                    })
                                })
                                layerUiIndex=layer.open({
                                    type: 1,
                                    title: false,
                                    closeBtn: 0,
                                    shadeClose: true,
                                    skin: 'yourclass',
                                    shadeClose:true,
                                    success:function(){
                                        if(layerUiIndex) layer.close(layerUiIndex)
                                    },
                                    content: $("#brand-popMsg")
                                });
                            })
                     }
                     if(whichLayer=="界碑"){
                        var url="/selectBoundaryList/"+spid;
                        for(item in boundaryPopupMsg.msg){
                            boundaryPopupMsg.msg[item]="";
                        }
                        $.get(url,function(data){
                            var msg=JSON.parse(data);
                            if(msg.count>0){
                                for(item in boundaryPopupMsg.msg){
                                    boundaryPopupMsg.msg[item]=msg.data[0][item];
                                }
                            }
                            $("#boundaryPopupSave").unbind("click").click(function(){
                                var changedMsg=boundaryPopupMsg.msg;
                                changedMsg.boundaryID=spid;
                                var urlForChanged="/updateBoundaryUrl/"+JSON.stringify(changedMsg);
                                $.get(urlForChanged,function (data) {
                                    console.log(data);
                                })
                            })
                            layer.open({
                                type: 1,
                                title: false,
                                closeBtn: 0,
                                shadeClose: true,
                                skin: 'yourclass',
                                content: $("#boundary-popMsg")
                            });
                        })
                     }
                     if(whichLayer=="人为干扰"){
                        var url="/querySpreadSub/"+spid+"/"+subid;
                        $.get(url,function(data){
                            var troubleMsg=JSON.parse(data);
                            console.log(troubleMsg.data[0]);
                            if(troubleMsg.count>0){
                                for(item in manTroblePopupMsg.msg){
                                    manTroblePopupMsg.msg[item]=troubleMsg.data[0][item];
                                }
                            }
                            $("#troublePopupSave").unbind("click").click(function(){
                                var msgForChange=manTroblePopupMsg.msg;
                                var changeUrl="/modification/"+JSON.stringify(msgForChange);
                                console.log(changeUrl);
                                $.get(changeUrl,function(data){
                                    console.log(data);
                                })
                            })
                        })
                         layer.open({
                             type: 1,
                             title: false,
                             closeBtn: 0,
                             shadeClose: true,
                             skin: 'yourclass',
                             content: $("#trouble-popMsg")
                         });
                     }
                     if(whichLayer=="灾害监测"){
                        var url="/queryDisasterSpreadSub/"+spid+"/"+subid;
                        console.log(url);
                        $.get(url,function(data){
                               var msgDisaster=JSON.parse(data).data[0];
                               for(item in msgDisaster){
                                   disasterPopupMsg.msg[item]=msgDisaster[item];
                               }
                        })
                         $("#disasterPopupSave").unbind("click").click(function(){
                             var msgChange=disasterPopupMsg.msg;
                             var url="/amendtheDisaster/"+JSON.stringify(msgChange);
                             $.get(url,function(data){
                                 console.log(data);
                             })
                         })
                         layer.open({
                             type: 1,
                             title: false,
                             closeBtn: 0,
                             shadeClose: true,
                             skin: 'yourclass',
                             content: $("#disaster-popMsg")
                         });
                     }
                     if(whichLayer=="生境点"){
                        var urlTranslate="/obtainHabitat/"+spid+"/"+subid;
                        var url="/obtainHabitat/"+spid+"/"+subid;
                        $.get(url,function(data){
                            var obtainHabitat=JSON.parse(data);
                            if(obtainHabitat.count>0){
                                for(item in habitatPopupMsg.msg){
                                    habitatPopupMsg.msg[item]=obtainHabitat.data[0][item]
                                }
                            }
                        })
                        $("#habitatPopupSave").unbind("click").click(function(){
                            var urlForChange="/updateHabitatSub/"+JSON.stringify(habitatPopupMsg.msg);
                            console.log(urlForChange);
                            $.get(urlForChange,function(data){
                                console.log(data);

                            })
                        })
                         layer.open({
                             type: 1,
                             title: false,
                             closeBtn: 0,
                             shadeClose: true,
                             skin: 'yourclass',
                             content: $("#habitat-popMsg")
                         });
                     }
                     if(whichLayer=="视频监控"){
                        var urlMsg="/selectVidicon/"+spid;
                        console.log(urlMsg);
                        $.get(urlMsg,function(data){
                            console.log(data);
                            if(JSON.parse(data).count>0) {
                                var msgData = JSON.parse(data)[0];
                                for(item in msgData){
                                    cameraPopupMsg.msg[item]=msgData[item]
                                }
                            }
                            layer.open({
                                type: 1,
                                title: false,
                                closeBtn: 0,
                                shadeClose: true,
                                skin: 'yourclass',
                                content: $("#camera-popMsg")
                            });
                        })
                         $("#cameraPopupSave").unbind("click").click(function(){
                             var changeMsg=cameraPopupMsg.msg;
                             var urlChange="/reviseCamera/"+JSON.stringify(changeMsg);
                             console.log(urlChange);
                             $.get(urlChange,function (data) {
                                 console.log(data);
                             })
                             layer.open({
                                 type: 1,
                                 title: false,
                                 closeBtn: 0,
                                 shadeClose: true,
                                 skin: 'yourclass',
                                 content: $("#quatrat-popMsg")
                             });
                         })
                     }
                     if(whichLayer=="样地代码"){
                          var urlMsg="/queryQuadratData/"+spid;
                          console.log(urlMsg);
                          $.get(urlMsg,function(data){
                              if(JSON.parse(data).count>0){
                                  var msgJson=JSON.parse(data).data[0];
                                  for(item in msgJson){
                                      quadratPopupMsg.msg[item]=msgJson[item]
                                  }
                              }
                          })
                         layer.open({
                             type: 1,
                             title: false,
                             closeBtn: 0,
                             shadeClose: true,
                             skin: 'yourclass',
                             content: $("#quatrat-popMsg")
                         });
                          $("#quadratPopupSave").unbind("click").click(function(){
                              var msgChange=quadratPopupMsg.msg;
                              var urlChange="/updateQuaDratDataIfon";
                              console.log(urlChange);
                              $.post(urlChange,'quadratData='+JSON.stringify(msgChange),function(data){
                                  console.log(data);
                              })
                          })
                     }
                }
                if(event.action.id==="popup-delete-msg"){
                       var getKey=$(".esri-feature__field-header");
                       var attributeObj={};
                       var layerSymbol; var deleteForUrl;var layerId;
                       for(var i=0;i<getKey.length;i++){
                           layerSymbol=getKey[0].innerHTML;
                           var key=$(getKey[i]).text();
                           var value=$(getKey[i]).next().text();
                            value=makesTring(value);
                           attributeObj[key]=value;
                       }
                        for(var i=0;i<mapData.layer.length;i++){
                            if(layerSymbol==mapData.layer[i].name){
                                deleteForUrl=mapData.layer[i].deleteUrl;
                                layerId=mapData.layer[i].id;
                                break;
                            }
                        }

                       if(deleteForUrl){
                            var urlArray=deleteForUrl.split("/");
                            for(var i=0;i<urlArray.length;i++){
                                if(attributeObj[urlArray[i]]) urlArray[i]=attributeObj[urlArray[i]]
                            }
                       }
                       var actulDelUrl="/"+urlArray.join("/");
                       if(attributeObj.OBJECTID){
                           var deleteObj={objectId:attributeObj.OBJECTID};
                           $.get(actulDelUrl,function(data){
                                     console.log(data);
                                     console.log(layerId);
                                     layerArray[layerId].applyEdits({
                                         deleteFeatures:[deleteObj]
                                     })
                           })
                       }
                }
            });
            $(".popupEdit").click(function(){
                $(".msgPopup").find("[name]").removeAttr("disabled");
            })

 //-------注释：------------------要素全选或者全取消显示---------------
             var allChooseCheckedBox=query(".all-choose");
             for(i=0;i<allChooseCheckedBox.length;i++){
                allChooseCheckedBox[i].onclick=function(){
                    var index=this.getAttribute("ifAllChoose");
                    var name=mapData.layer[index].showSymbol;
                    var condition="input[name="+name+"]";
                    var childChoose=query(condition);
                    if(this.checked==true){
                      if(layerArray[index].definitionExpression){
                          if(layerArray[index].definitionExpression.indexOf("and")==-1)  layerArray[index].definitionExpression="OBJECTID>-1 and NativeCode=40000";
                          else {layerArray[index].definitionExpression="OBJECTID>-1"+" and "+layerArray[index].definitionExpression.split("and")[1]}
                      }
                      else{
                          layerArray[index].definitionExpression="OBJECTID>-1 and NativeCode=40000"
                      }
                         mapData.layer[index].filterShow=mapData.layer[index].filterShowCopy;
                         for(i=0;i<childChoose.length;i++){
                            childChoose[i].checked=true;
                         }
                        var optionNameList=mapData.layer[index].filterShowCopy;
                        setTimeout(feature(optionNameList,index),300);
                    }
                    else{
                        mapData.layer[index].filterShow=[];
                        var optionNameList=[];
                        setTimeout(feature(optionNameList,index),300);
                        if(layerArray[index].definitionExpression){
                            if(layerArray[index].definitionExpression.indexOf("and")==-1)  layerArray[index].definitionExpression="OBJECTID=-100 and NativeCode=40000";
                            else {layerArray[index].definitionExpression="OBJECTID=-100"+" and "+layerArray[index].definitionExpression.split("and")[1]}
                        }
                        else{

                            layerArray[index].definitionExpression="OBJECTID=-100 and NativeCode=40000"
                        }
                        for(i=0;i<childChoose.length;i++){
                            childChoose[i].checked=false;
                        }
                    }
                    console.log(layerArray[index].definitionExpression);
                }
            }
//-------注释：------------------重置事件函数---------------
            document.getElementById("resetShow").onclick=function(){
                for(i=0;i<layerChoose.length;i++){
                    var num=i;
                    layerChoose[num].checked=false;
                    layerArray[num].visible=false;
                }
                for(i=0;i<mapData.layer.length;i++){
                    mapData.layer[i].showIf=false;
                }
            }
           var changeToLineExtent=function() {
               $(".lineListShow").click(
                   function () {
                       var index=$(this).attr("data-id");
                     view.extent= lineData.line[index].lineExtent;
                  // view.zoom=view.zoom*0.8;
                   }
               )
               $(".chooseCreatedLine").click(function(){
                       var index=$(this).attr("data-id");
                       if(this.checked==true){
                           view.graphics.add(lineStoreArray[index]);
                           view.graphics.addMany(prtrolWatchPoint[index]);
                       }
                   if(this.checked==false){
                       view.graphics.remove(lineStoreArray[index]);
                       view.graphics.removeMany(prtrolWatchPoint[index]);
                   }
               })
           }
//-------注释：------------------表格生成线路---------------
            var count=0;
            var prtrolWatchPoint=new Array();
            var lineStoreArray=new Array();
            table.on("tool(test)",function(obj){
                var polylineSymbol = {
                    type: "simple-line",  // autocasts as SimpleLineSymbol()
                    color: [226, 119, 40],
                    width: 2
                };
                var curData = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'createLine'){
                    if($(this).attr("data-alreadyCreated")=="true"){
                        return;
                    };
                    this.innerHTML="已经生成";
                    $(this).attr("data-alreadyCreated",true);
                    this.style.backgroundColor="grey";
                    var url="/selectList?patrolId="+curData.patrolId;
                    $.get(url,function(data,status){
                        var oneLine=new Object();
                        oneLine.name=curData.patrolPlanName;
                        var JsonData=JSON.parse(data);
                        var xArray=new Array(); var yArray=new Array();
                        for(var i=0;i<JsonData.data.length;i++){
                            JsonData.data[i][0]= JsonData.data[i][0]*1;
                            JsonData.data[i][1]= JsonData.data[i][1]*1;
                            xArray.push(JsonData.data[i][0]);
                            yArray.push(JsonData.data[i][1]);
                        }
                        var xArraySort=xArray.sort(); var yArraySort=yArray.sort();
                        var extent=new Extent();
                        extent.xmin=xArraySort[xArraySort.length-1]; extent.xmax=xArraySort[0];
                        extent.ymin=yArraySort[yArraySort.length-1]; extent.ymax=yArraySort[0];
                        extent.spatialReference=4326;
                        oneLine.lineExtent=extent;
                        oneLine.path=JsonData.data;
                        oneLine.id=count;
                        var polyline = {
                            type: "polyline",  // autocasts as new Polyline()
                            paths:JsonData.data
                        };
                        var polylineGraphic = new Graphic({
                            geometry: polyline,
                            symbol: polylineSymbol,
                        });
                        lineStoreArray[count]=polylineGraphic;
                        view.graphics.add(lineStoreArray[count]);
                        lineData.line.push(oneLine);
                        count++;
                        setTimeout(changeToLineExtent,300);
                    })
                    //-------注释：------------------生成巡护线路上的点---------------
                    var msgTranslateUrl="/setDesignationService?patroid="+curData.patrolId;
                    var msgStore;
                    $.get(msgTranslateUrl,function(data){
                         var msg=JSON.parse(data);
                         if(msg.count==0) return;
                         msgStore=msg.data;
                        var urlPoint="/patrolInfo?patrolId="+curData.patrolId;
                        $.get(urlPoint,function (data) {
                            var pointBelongLine=new Array();
                            var symbol={
                                type:"simple-marker",
                                color:[173,216,230]
                            }
                            var pointJson=JSON.parse(data);
                            if(pointJson.count==0){prtrolWatchPoint.push(new Array());return}
                            for(i=0;i<pointJson.data.patrolFindInfoSub.length;i++){
                                var point={
                                    type:"point",
                                    longitude:pointJson.data.patrolFindInfoSub[i].lng,
                                    latitude:pointJson.data.patrolFindInfoSub[i].lat
                                }
                                var pointMsg={
                                    title:"信息如下",
                                    //content:"<ul><li>动物名字："+pointJson.data.patrolFindInfoSub[i].animalName+" 发现时间:"+pointJson.data.patrolFindInfoSub[i].monitorTime+"</li></ul>"
                                    content:"<table class='show-patrol-msg'><tr>" +
                                    "<td>动物名字："+pointJson.data.patrolFindInfoSub[i].animalName+"</td>"+
                                    "<td>发现时间："+pointJson.data.patrolFindInfoSub[i].monitorTime+"</td></tr>"+
                                    "<tr><td>发现地点："+pointJson.data.patrolFindInfoSub[i].monitorAddress+"</td>"+
                                    "<td>动物行为："+msgStore[pointJson.data.patrolFindInfoSub[i].action]+"</td></tr>"+
                                    "<tr><td>距离动物："+pointJson.data.patrolFindInfoSub[i].diatance+"</td>"+
                                    "<td>所处环境："+msgStore[pointJson.data.patrolFindInfoSub[i].habitatId]+"</td></tr>"+
                                    "<tr><td>痕迹留下时间："+msgStore[pointJson.data.patrolFindInfoSub[i].traceTime]+"</td>"+
                                    "<td>获取痕迹："+msgStore[pointJson.data.patrolFindInfoSub[i].traceType]+"</td></tr>"+
                                    "<tr><td>地形："+msgStore[pointJson.data.patrolFindInfoSubSJYZ [i].terrain]+"</td>"+
                                    "<td>地质："+msgStore[pointJson.data.patrolFindInfoSubSJYZ[i].coverColloid]+"</td>"+
                                    "</tr></table>"
                                }
                                pointBelongLine.push(
                                    new Graphic({
                                        symbol: symbol,
                                        geometry: point,
                                        popupTemplate:pointMsg
                                    })
                                )
                            }
                            prtrolWatchPoint.push(pointBelongLine);
                            view.graphics.addMany(prtrolWatchPoint[prtrolWatchPoint.length-1])
                        })
                    })
                }
            })
//-------注释：------------------线路模拟巡护---------------
            var markerSymbol = {
                type: "simple-marker", // autocasts as new SimpleMarkerSymbol()
                color: [126, 129, 140],
            };
            lineData.onGoing=new Array();
             lineData.simulate=function(data,patrolIndex){
                 // 如果模拟巡护没有结束，返回
                 if(!(lineData.onGoing.indexOf(patrolIndex)==-1))  return;
                 lineData.onGoing.push(patrolIndex);
                var visible=document.getElementsByClassName("chooseCreatedLine")[patrolIndex].checked;
                if(!visible){
                    alert("线路已经被隐藏，请先展现线路再模拟巡护");
                    return;
                }
                var stepTimes=new Array();          // 线路上两点间的点的个数
                 var eachStepDetail=new Array();   //  模拟巡护，线路上所有的点
                 var count=0;                         //  点运行第几个位置，计数
                for(var i=0;i<data.length-1;i++){
                    stepTimes.push(Math.ceil(Math.sqrt((data[i+1][0]-data[i][0])*(data[1+i][0]-data[i][0])+(data[1+i][1]-data[i][1])*(data[1+i][1]-data[i][1]))/0.00005));
                }

                //  生成线路上运动的点的轨迹
                for(var t=0;t<stepTimes.length;t++){
                    if(stepTimes[t]==0) {continue;}
                    for(var tt=0;tt<stepTimes[t];tt++){
                        var eachPoint=new Array();
                        if(tt==stepTimes[t]){
                            eachPoint[0]=data[t+1][0];
                            eachPoint[1]=data[t+1][1];
                        }
                        else{
                            eachPoint[0]=data[t][0]+(data[t+1][0]-data[t][0])/stepTimes[t]*(tt+1);
                            eachPoint[1]=data[t][1]+(data[t+1][1]-data[t][1])/stepTimes[t]*(tt+1);
                        }
                        eachStepDetail.push(eachPoint);
                    }
                }
                         // 定义点的运动函数
                      var timer;    //定时器
                      var pointGraphic;
                      var pointStep=function(){
                          if(pointGraphic){view.graphics.remove(pointGraphic)}
                          if(count==eachStepDetail.length){
                              window.clearInterval(timer);
                              var changeSimulateStatus=lineData.onGoing.indexOf(patrolIndex);
                              lineData.onGoing.splice(changeSimulateStatus,1);    // 模拟巡护已经完成
                              return;
                          }
                          var point = {
                              type: "point", // autocasts as new Point()
                              longitude:eachStepDetail[count][0],
                              latitude: eachStepDetail[count][1],
                          };
                          count++;
                          pointGraphic = new Graphic({
                              geometry: point,
                              symbol: markerSymbol
                          });

                          view.graphics.add(pointGraphic);

                      }
                      var speed=document.getElementById("speed").value;
                      timer=setInterval(pointStep,speed);
              }

 //-------注释：------------------测量两点距离---------------
            var measureTwoPointStore;var measureLineStore; var measureAreastore=new Array();var measureArea;

            var TwoPointSymbol = {
                type: "simple-marker", // autocasts as new SimpleMarkerSymbol()
                color: [255, 69, 0],
            };
            var twoPointpolylineSymbol = {
                type: "simple-line",  // autocasts as SimpleLineSymbol()
                color: [255, 69, 0],
                width: 2
            };
            var polygonSymbol={
                type: "simple-fill", // autocasts as new SimpleFillSymbol()
                    color: "rgba(138,43,226, 0.8)",
                    style: "solid"}

              //   测量功能
            view.on("click", function(event){
                //  测量时屏蔽弹出框
                if(menuStatus==0){featureLayer.popupEnabled=true}
                else{featureLayer.popupEnabled=false}
                if(menuStatus==3){
                    toolData.addLat=event.mapPoint.longitude.toFixed(6);
                    toolData.addLng=event.mapPoint.latitude.toFixed(6);
                }
                if(!(menuStatus==2)) {return}
                //  获取屏幕点击的点经纬度
                var pointLocation = new Array();
                pointLocation.push(event.mapPoint.longitude.toFixed(6));
                pointLocation.push(event.mapPoint.latitude.toFixed(6));
                //  测量两点距离
                if(measureStatus=="measureTwoPoint") {

                    // event is the event handle returned after the event fires.
                    if (measureData.twoPoint.length == 2) {
                        measureData.twoPoint.splice(0, 2);
                        measureData.twoPointResult = "";
                    }

                    measureData.twoPoint.push(pointLocation);
                    if (measureData.twoPoint.length == 1) {
                        if (measureTwoPointStore) {
                            view.graphics.remove(measureTwoPointStore)
                        }

                        var point = {
                            type: "point", // autocasts as new Point()
                            longitude: measureData.twoPoint[0][0],
                            latitude: measureData.twoPoint[0][1],
                        };
                        measureTwoPointStore = new Graphic({
                            symbol: TwoPointSymbol,
                            geometry: point
                        })
                        view.graphics.add(measureTwoPointStore);
                    }
                    if (measureData.twoPoint.length == 2) {
                        view.graphics.remove(measureTwoPointStore);
                        var line = {
                            type: "polyline",
                            paths: measureData.twoPoint
                        }
                        measureTwoPointStore = new Graphic({
                            symbol: twoPointpolylineSymbol,
                            geometry: line
                        })
                        view.graphics.add(measureTwoPointStore);
                        var p1 = measureData.twoPoint[0];
                        var p2 = measureData.twoPoint[1];
                        measureData.twoPointResult = measureTwoPoint(p1, p2).toFixed(2);
                    }
                }
                // 测量线路距离
                 if(measureStatus=="measureLine"){
                     measureData.linePoint.push(pointLocation);
                     if(measureData.linePoint.length==1){
                         var point={
                             type:"point",
                             longitude:measureData.linePoint[0][0],
                             latitude:measureData.linePoint[0][1]
                         }
                         measureLineStore=new Graphic({
                             symbol:TwoPointSymbol,
                             geometry:point
                         })
                         view.graphics.add(measureLineStore);
                     }
                  if(measureData.linePoint.length>1){
                         view.graphics.remove(measureLineStore);
                         var line={
                             type:"polyline",
                             paths:measureData.linePoint
                         }
                         measureLineStore=new Graphic({
                             symbol:twoPointpolylineSymbol,
                             geometry:line
                         })
                         view.graphics.add(measureLineStore);

                      var dis = AMap.GeometryUtil.distanceOfLine(measureData.linePoint);
                          measureData.linePointResult=dis.toFixed(2);
                     }
                 }
                 // 测量区域面积
                if(measureStatus=="measureArea"){
                    measureData.areaPoint.push(pointLocation);
                    if(measureData.areaPoint.length<3){

                        var point={
                            type:"point",
                            longitude:pointLocation[0],
                            latitude:pointLocation[1]
                        }
                        var areaPoint=new Graphic({
                            symbol:TwoPointSymbol,
                            geometry:point
                        })
                        measureAreastore.push(areaPoint);
                        view.graphics.add(measureAreastore[measureAreastore.length-1]);
                    }
                    if(measureData.areaPoint.length>2){
                         if(measureAreastore.length==2){
                             view.graphics.remove(measureAreastore[0]);
                             view.graphics.remove(measureAreastore[1]);
                             measureAreastore.splice(0,2);
                         }
                         if(measureArea){view.graphics.remove(measureArea)}
                         var lineToRing=new Array();
                         lineToRing=measureData.areaPoint;
                         lineToRing.push(measureData.areaPoint[0]);
                         var fillArea={
                             type:"polygon",
                             rings:lineToRing
                         }
                         var fillAreaCreated=new Graphic({
                             symbol:polygonSymbol,
                             geometry:fillArea
                         })

                        measureData.areaPoint.splice(measureData.areaPoint.length-1,1);
                        measureArea=fillAreaCreated;
                        view.graphics.add(measureArea);
                        var area = AMap.GeometryUtil.ringArea(measureData.areaPoint).toFixed(2);
                        measureData.areaPointResult=area;
                    }
                }
            });
            // 要素新增
            // 初始化数据
             var initializ=function(data){
                 for(item in data){
                     data[item]="";
                 }
             }
            $("#addFeature").click(function(){
                if(!(userLogin=="superUser")) {alert("只有超级用户才能增加要素");return}
                if(toolData.addLng=="") {alert("请先点击地图确定要添加的要素的坐标");return}
                featureOpration.add=true;
                var templateValue="#"+$("#addWhichLayer").val();
                 if($("#addWhichLayer").val()=="brand-popMsg"){
                    initializ(brandPopupMsg.msg);
                    $("#brandPopupSave").unbind("click").click(function(){
                        var addMsg=brandPopupMsg.msg;
                        delete  addMsg.brandID;
                        var json=  JSON.stringify(addMsg);
                        var urlForAdd="/raiseBotanyIfonUrl/"+json;
                        console.log(urlForAdd);
                        $.get(urlForAdd,function(data){
                            var point={
                                type:"point",
                                longitude:toolData.addLat,
                                latitude:toolData.addLng
                            }
                            var attibutes={
                                BrandName:brandPopupMsg.msg.brandName,
                                BrandID:data,
                                NativeCode:40000
                            }
                            console.log(attibutes);
                            var addGraphic=new Graphic({
                                geometry:point,
                                attributes:attibutes
                            })
                            layerArray[2].applyEdits({
                                addFeatures:[addGraphic]
                            })
                        })

                    })
                }
                 if($("#addWhichLayer").val()=="boundary-popMsg"){
                   initializ(boundaryPopupMsg.msg);
                    $("#boundaryPopupSave").unbind("click").click(function(){
                        var addMsg=boundaryPopupMsg.msg;
                        delete  addMsg.boundaryID;
                        var msgJson=JSON.stringify(addMsg);
                        var urlForAdd="/raiseBoundaryIfonUrl/"+msgJson;
                        $.get(urlForAdd,function(data){
                            console.log(data);
                            var point={
                                type:"point",
                                longitude:toolData.addLat,
                                latitude:toolData.addLng,
                            }
                            var attibutes={
                                BoundaryNa:boundaryPopupMsg.msg.boundaryName,
                                BoundaryID:data,
                                NativeCode:40000
                            }
                            var addPoint=new Graphic({
                                geometry:point,
                                attributes:attibutes
                            })
                            layerArray[5].applyEdits({
                                addFeatures:[addPoint]
                            })
                        })
                    })
                }
                 if($("#addWhichLayer").val()=="plant-popMsg"){
                       initializ(plantPopupMsg.msg);
                       $("#plantPopupSave").unbind("click").click(function(){
                               var plantMsg=plantPopupMsg.msgMonitor;
                               delete plantMsg.SPID;
                               plantMsg.PatrolSubId=0;
                               var urlForAddPlant="/raisePlankIfon/"+JSON.stringify(plantMsg);
                               $.get(urlForAddPlant,function(data){
                                   var point = {
                                       type:"point",  // autocasts as new Point()
                                       longitude:toolData.addLat,
                                       latitude:toolData.addLng
                                   };
                                   var plantAttr={
                                       SPID:data,
                                       PatrolSubI:"0",
                                       BotanyCode:"43007-P020205001135003",
                                       BotanyName:plantMsg.botanyName
                                   }
                                   var pointGraphic=new Graphic({
                                       geometry: point,
                                       attributes:plantAttr
                                   })
                                   layerArray[1].applyEdits({
                                       addFeatures:[pointGraphic]
                                   })
                               })
                       })
                 }
                 if($("#addWhichLayer").val()=="animal-popMsg"){
                     initializ(animalPopupMsg.msg)
                     $("#animalPopupSave").unbind("click").click(function(){
                         var msgData=animalPopupMsg.msgMonitor;
                         delete  msgData.SPID;
                         msgData.patrolSubId=0;
                         var urlForAdd="/raiseAnimalIfon/"+JSON.stringify(msgData);
                         $.get(urlForAdd,function(data){
                             // First create a point geometry
                             var point = {
                                 type: "point",  // autocasts as new Point()
                                 longitude: toolData.addLat,
                                 latitude: toolData.addLng
                             };
                             console.log(point);
// Create a symbol for drawing the point
                             var markerSymbol = {
                                 type: "simple-marker",  // autocasts as new SimpleMarkerSymbol()
                                 color: [226, 119, 40]
                             };

                             var featureAttribute={
                                 SPID:data,
                                 PatrolSubI:"0",
                                 NativeCode:"40000",
                                 AnimalCode:"43007-A020101025015013",
                                 AnimalName:msgData.animalName
                             }
// Create a graphic and add the geometry and symbol to it
                             var pointGraphic = new Graphic({
                                 geometry: point,
                                 //  symbol:markerSymbol,
                                 attributes:featureAttribute
                             });
                             layerArray[0].applyEdits({
                                 addFeatures:[pointGraphic]
                             })
                         })
                     })
                 }
                 if($("#addWhichLayer").val()=="habitat-popMsg"){
                     initializ(habitatPopupMsg.msg);
                      $("#habitatPopupSave").unbind("click").click(function(){
                          var msgForAdd=habitatPopupMsg.msg;
                          delete msgForAdd.SPID;
                          delete msgForAdd.patrolId;
                          var urlForAdd="/raiseSpreadUrl/"+JSON.stringify(habitatPopupMsg.msg);
                          console.log(urlForAdd);
                          $.get(urlForAdd,function(data){
                              console.log(data);
                              if(JSON.parse(data).count>0){
                                  var backSpid=JSON.parse(data).data[0];
                                  var backSubid=JSON.parse(data).data[1];
                                  var point = {
                                      type: "point",  // autocasts as new Point()
                                      longitude: toolData.addLat,
                                      latitude: toolData.addLng
                                  };
                                  var attribute={
                                      SPID:backSpid,
                                      PatrolId:backSubid,
                                      NativeCode:40000
                                  }
                                  var addPoint=new Graphic({
                                      geometry:point,
                                      attributes:attribute
                                  })
                                  layerArray[3].applyEdits({
                                      addFeatures:[addPoint]
                                  })
                              }
                          })
                      })
                 }
                 if($("#addWhichLayer").val()=="camera-popMsg"){
                     initializ(cameraPopupMsg.msg);
                     $("#cameraPopupSave").unbind("click").click(function () {
                           var msgForAdd=cameraPopupMsg.msg;
                           delete msgForAdd.CameraId;
                           var url="/raiseCameraUrl/"+JSON.stringify(msgForAdd);
                           console.log(url);
                           $.get(url,function(data){
                               console.log(data);
                               var point = {
                                   type: "point",  // autocasts as new Point()
                                   longitude: toolData.addLat,
                                   latitude: toolData.addLng
                               };
                               var attribute={
                                   CameraId:data,
                                   CameraName:msgForAdd.CameraName,
                                   NativeCode:40000
                               }
                               var addPoint=new Graphic({
                                   geometry:point,
                                   attributes:attribute
                               })
                               layerArray[8].applyEdits({
                                   addFeatures:[addPoint]
                               })
                           })
                     })
                 }
                 if($("#addWhichLayer").val()=="trouble-popMsg"){
                    initializ(manTroblePopupMsg.msg);
                    $("#troublePopupSave").unbind("click").click(function () {
                        var msgForAdd=manTroblePopupMsg.msg;
                        delete msgForAdd.patrolId;
                        delete msgForAdd.SPID;
                        var url="/addModification/"+JSON.stringify(msgForAdd);
                        console.log(url);
                        encodeURI(url,"utf-8");
                        $.get(url,function(data){
                            console.log(data);
                            var getData=JSON.parse(data).data;
                            var point = {
                                type: "point",  // autocasts as new Point()
                                longitude: toolData.addLat,
                                latitude: toolData.addLng
                            };
                            var attribute={
                                SPID:getData[0],
                                PatrolId:getData[1],
                                NativeCode:40000
                            }
                            var addPoint=new Graphic({
                                geometry:point,
                                attributes:attribute
                            })
                            layerArray[6].applyEdits({
                                addFeatures:[addPoint]
                            })
                        })
                    })
                }
                 if($("#addWhichLayer").val()=="disaster-popMsg"){
                      initializ(disasterPopupMsg.msg);
                      var msgAdd=disasterPopupMsg.msg;
                      delete msgAdd.SPID;
                      delete msgAdd.patrolId;
                      $("#disasterPopupSave").unbind("click").click(function(){
                          var urlAdd="/addXhdisaster/"+JSON.stringify(msgAdd);
                          console.log(urlAdd);
                          $.get(urlAdd,function(data){
                              console.log(data);
                              var getData=JSON.parse(data).data;
                              var point = {
                                  type: "point",  // autocasts as new Point()
                                  longitude: toolData.addLat,
                                  latitude: toolData.addLng
                              };
                              var attribute={
                                  SPID:getData[0],
                                  PatrolId:getData[1],
                                  NativeCode:40000
                              }
                              var addPoint=new Graphic({
                                  geometry:point,
                                  attributes:attribute
                              })
                              layerArray[7].applyEdits({
                                  addFeatures:[addPoint]
                              })
                          })
                      })
                 }
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    shadeClose: true,
                    skin: 'yourclass',
                    content: $(templateValue),
                    end:function () {
                        featureOpration.add=false;

                    }
                });
            })
            $("#reset-measure").click(function(){
                 if(measureStatus=="measureTwoPoint"){
                      view.graphics.remove(measureTwoPointStore);
                      measureData.twoPoint.splice(0,measureData.twoPoint.length)
                     measureData.twoPointResult="";
                 }
                if(measureStatus=="measureLine"){
                    view.graphics.remove(measureLineStore);
                    measureData.linePoint.splice(0,measureData.linePoint.length)
                    measureData.linePointResult="";
                }
                if(measureStatus=="measureArea"){
                    if(measureAreastore[0])view.graphics.remove(measureAreastore[0]);
                    if(measureAreastore[1])view.graphics.remove(measureAreastore[1]);
                    if(measureArea)view.graphics.remove(measureArea);
                    measureAreastore.splice(0,measureAreastore.length);
                    measureData.areaPoint.splice(0,measureData.areaPoint.length);
                    measureData.areaPointResult="";
                }
            })
            $("#loctionAction").click(function(){
                 var point=[];point[0]=toolData.location[0]*1;point[1]=toolData.location[1]*1;
               //  view.goTo(point);
                 view.center=point;
                 view.zoom=13;
            })

        });
};