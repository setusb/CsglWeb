/**
 * Created by yaling.he on 2015/11/18.
 */
//ʱ��
function fn(){
    var time = new Date();
    var str= "";
    var div = document.getElementById("time");
	var hour = document.getElementById("hours");
//    console.log(time);
    var year = time.getFullYear();
    var mon = time.getMonth()+1;
    var day = time.getDate();
    var h = time.getHours();
    var m = time.getMinutes();
    var s = time.getSeconds();
    var week = time.getDay();
    switch (week){
        case 0:week="��";
            break;
        case 1:week="һ";
            break;
        case 2:week="��";
            break;
        case 3:week="��";
            break;
        case 4:week="��";
            break;
        case 5:week="��";
            break;
        case 6:week="��";
            break;
    }
    str = year +"��"+totwo(mon)+"��"+totwo(day)+"��"+"&nbsp;"+totwo(h)+":"+totwo(m)+":"+totwo(s)+"&nbsp;"+"����"+week;
    div.innerHTML = str;
	if(h < 6){
		hour.innerHTML = "�賿��";
	} else if(h < 12){
		hour.innerHTML = "�����";
	} else if(h < 15){
		hour.innerHTML = "�����";
	} else if(h < 18){
		hour.innerHTML = "�����";
	} else if(h < 21){
		hour.innerHTML = "�����";
	} else {
		hour.innerHTML = "��ҹ��";
	}
}
fn();
setInterval(fn,1000);
function totwo(n){
    if(n<=9){
        return n = "0"+n;
    }
    else{
        return n =""+n;
    }
}

