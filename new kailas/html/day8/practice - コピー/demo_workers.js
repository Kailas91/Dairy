var today = new Date();
var i =today.getSeconds();
function timedCount() {
  i = i + 1;
  if(i==60){
    //Increments the counter variable by 1
    postMessage(today.getHours() + ":" + today.getMinutes()+1+ ":" +i);
    //return the current i value
    setTimeout("timedCount()",400);
    //set maximun timeout limit
    i=today.getSeconds();
  }
  postMessage(today.getHours() + ":" + today.getMinutes()+ ":" +i);
  //return the current i value
  setTimeout("timedCount()",400);
}
timedCount();
var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
