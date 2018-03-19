function change(){
		$("h1").click(function(){
			$(".title").css("color","blue");
		});
		var cat1 = new Cat("橘猫","orange");
		var cat2 = new Cat("黑猫","black");
		alert(cat1.name+","+cat1.color+","+cat1.type);
		cat1.eat();
		alert(cat1.constructor == Cat );//对象含有一个constructor属性，指向它们的构造函数
		alert(cat2 instanceof Cat) ;//instanceof运算符，验证原型对象与实例对象之间的关系
		alert(this);
}
function Cat(name,color){
	this.name = name ;
	this.color = color ;
}
//每一个构造函数都有一个prototype属性，指向另一个对象。
//这个对象的所有属性和方法，都会被构造函数的实例继承。
	Cat.prototype.type = "猫科动物";
	Cat.prototype.eat = function(){alert("吃老鼠");};
