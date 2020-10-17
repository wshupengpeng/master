# master
学习记录
今日总结:
1 构建AOP切面日志工作
   遇到问题： （1） 切入点规则问题：通过切面表达式+@Annotation配合获取当前包下的请求接口+被log注解
   包含的接口。
   一、@Pointcut(value = "@annotation(com.huawei.annotation.Log) || " +"execution(public * com.huawei.api..*(..))")
   二、基于注解作为切面方程的@Around(value = "@annotation(log)")  拦截所有带有Log注解的接口
   三、多个point（）可以通过 || && ！来进行表达式的组合拓展
   
   （2） 切面返回值问题：
		一、被代理类含有返回值，需要切面方程返回返回值，否则返回null值，如果返回值为基本数据类型且
		代理类没有返回值，则会导致报错，原因在于如果代理方法返回值为void则默认返回null值，而基本数据
		类型没有null值，导致报错。
		解决方法：返回值设置为Object，获取被代理类的返回值对象，返回被代理类的返回值对象。
		（ps：如果被代理类返回值为void，proceed执行后的结果为null）
		二、将基本数据类型改为包装类，如果代理类返回值为null，则会报错，改为包装类则可以接受为null值。
    扩展知识：可以通过args、bean 获取被代理类的参数信息，within、this、target、annotation获取指定注解内的方法
	，注解类型也必须是全限定类型名，必须是在目标对象上声明这个注解，在接口上声明的对它不起作用。
	
	例子：
		@Before(value=" args(param)", argNames="param") //明确指定了参数  
		public void before1(String param) {  
			System.out.println("===param:" + param);  
		} 
		如果“class文件中含有变量调试信息”将使用这些方法签名中的参数名来确定参数名；
		
		@Before(value=" args(param)") //不需要argNames了  
		public void before1(JoinPoint jp, String param) {  
			System.out.println("===param:" + param);  
		}
		
		@Before(args(param) && target(bean) && @annotation(secure)",   
				argNames="jp,param,bean,secure")  
		public void before5(JoinPoint jp, String param,  
		 IPointcutService pointcutService, Secure secure) {  
		……  
		} 
		
		解释： target必须写出实现的接口类型 args如果想要命中，必须写上所有的被代理类的请求参数，缺少一个都不能拦截。
		annotation不用解释了。
   （3） mybatis的日期字段精确到时分秒需要使用jdbcType=TIMESTAMP类型。
   （4） mybatis的<foreach>标签中的collection当数据为list时使用list，如果加上@Param注解则注解Id为准。
   （5） 通过spring的LocalVariableTableParameterNameDiscoverer可以通过反射获取Method中的参数名。
	 LocalVariableTableParameterNameDiscoverer discoverer=new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
		parameterNames 不为null遍历即可获取方法上的参数名称。
   （6）可以通过当前方法获取当前线程下的request对象。 
     ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
   
