- 创建型模式
    - 1、单例（Singleton）
    >单例模式的应用场景<br>
     前面分析了单例模式的结构与特点，以下是它通常适用的场景的特点。
     在应用场景中，某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
     当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
     当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等<br>
     
     >单例模式有 3 个特点：<br>
     单例类只有一个实例对象；<br>
     该单例对象必须由单例类自行创建；<br>
     单例类对外提供一个访问该单例的全局访问点；<br>
     
     >创建方法：懒汉模式、饿汉模式、枚举单例
     
    - 2、原型
    >用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，<br>
    原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。<br>
    
    >原型模式包含以下主要角色<br>
     1、抽象原型类：规定了具体原型对象必须实现的接口。<br>
     2、具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。<br>
     3、访问类：使用具体原型类中的 clone() 方法来复制新的对象。<br>
     
     >原型模式通常适用于以下场景。<br>
      1、对象之间相同或相似，即只是个别的几个属性不同的时候。<br>
      2、对象的创建过程比较麻烦，但复制比较简单的时候。<br>

    >创建方法：由于 Java 提供了对象的 clone() 方法，所以用 Java 实现原型模式很简单
    - 3、工厂方法
    >定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。
    
    >工厂方法模式的主要优点有：<br>
    1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；<br>
    2、在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；<br>
    其缺点是：<br>
    1、每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度
    
    >模式的结构与实现<br>
    工厂方法模式由抽象工厂、具体工厂、抽象产品和具体产品等4个要素构成。本节来分析其基本结构和实现方法。<br>
     1、模式的结构<br>
    工厂方法模式的主要角色如下。<br>
    抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。<br>
    具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。<br>
    抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。<br>
    具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应<br>
   
    >模式的应用场景<br>
     工厂方法模式通常适用于以下场景。<br>
     客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。<br>
     创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。<br>
     客户不关心创建产品的细节，只关心产品的品牌。<br>
    
    - 4、抽象工厂
    > 抽象工厂（AbstractFactory）模式：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。<br>
     抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
    
    >使用抽象工厂模式一般要满足以下条件。<br>
     系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。<br>
     系统一次只可能消费其中某一族产品，即同族的产品一起使用。<br>
     
    >主要优点:<br>
     可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。<br>
     当增加一个新的产品族时不需要修改原代码，满足开闭原则。<br>
     缺点:<br>
     当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。
     
     - 模式的结构
        - 抽象工厂模式的主要角色如下。
        - 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
        - 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
        - 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
        - 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。
   
   >模式的应用场景<br>
     抽象工厂模式最早的应用是用于创建属于不同操作系统的视窗构件。如 java 的 AWT 中的 Button 和 Text 等构件在 Windows 和 UNIX 中的本地实现是不同的。
     
     >抽象工厂模式通常适用于以下场景：<br>
     当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
     系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
     系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
     
     >模式的扩展<br>
     抽象工厂模式的扩展有一定的“开闭原则”倾斜性：
     当增加一个新的产品族时只需增加一个新的具体工厂，不需要修改原代码，满足开闭原则。
     当产品族中需要增加一个新种类的产品时，则所有的工厂类都需要进行修改，不满足开闭原则。
     
     >另一方面，当系统中只存在一个等级结构的产品时，抽象工厂模式将退化到工厂方法模式。
    - 5、建造者