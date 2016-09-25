
静态代理
	一个代理类和被代理类实现同一个接口;
	例子:UserServiceImpl类、UserServiceProxy累都实现接口UserService;
	静态代理本身是一种架构模式;
	
动态代理
	a.动态代理处理器
		必须实现java.lang.reflect.InvocationHandler接口;
	b.把目标对象(要生成代理的对象)作为成员;
	c.实现接口的时候要重写invoke方法，该方法会拦截目标对象的所有方法;
	d.产生代理对象
		可以直接利用代理处理器类，也可以单独写一个类
	e.缺点： 	目标对象的所有方法都会被拦截
			 将来可以根据方法对象的细致参数来控制