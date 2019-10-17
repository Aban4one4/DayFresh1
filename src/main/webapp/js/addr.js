window.onload=function(){
	var pro=document.getElementById("province");
	var city=document.getElementById("city");
	var area=document.getElementById("area");

	var dom;
	var xmlhttp=new XMLHttpRequest();

	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			if(xmlhttp.status==200){
				dom=xmlhttp.responseXML.documentElement;

				//获取所有的省份
				var pros=dom.getElementsByTagName("province");

				var len=pros.length;

				for(var i=0;i<len;i++){
					addOption(pros.item(i),pro);
				}
				var cities;
				var citylen;


				pro.onchange=function(){
					var flag=pro.value;

					city.length=0;

					for(var i=0;i<len;i++){
						if(pros[i].nodeType==1&&pros[i].getAttribute("name")==flag){


							//取出该省份下的所有城市
							cities=pros[i].childNodes;
							citylen=cities.length;
							for(var j=0;j<citylen;j++){
								addOption(cities[j],city);
							}

							city.onchange();
							break;
						}
					}
				}

				//当城市发生改变的时候
				city.onchange=function(){
					var index=city.value;

					area.length=0;

					for(var i=0;i<citylen;i++){
						if(cities[i].nodeType==1&&cities[i].getAttribute("name")==index){
							var areas=cities[i].childNodes;
							var arealen=cities.length;
							for(var j=0;j<arealen;j++){
								addOption(areas[j],area);
							}
							break;
						}
					}

					//		
				}
			}
		}
	}
	xmlhttp.open("GET","../xml/city.xml",true);
	xmlhttp.send(null);


}
function addOption(node,obj){
	if(node!=undefined&&node.nodeType==1){
		var opt=document.createElement("option");
		opt.setAttribute("value", node.getAttribute("name"));
		opt.appendChild(document.createTextNode(node.getAttribute("name")));
		obj.appendChild(opt);
	}
}
