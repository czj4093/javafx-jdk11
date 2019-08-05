javafx
	javafx.base	定义JavaFX UI工具包的基本api，包括用于绑定、属性、集合和事件
		beans
			binding
			property
				adapter
			value
			collections
				transformation
			event
			util
				converter
			@interface	DefaultProperty 指定将向其添加或设置子元素的属性没有给出显式属性
			interface	InvalidationListener	当观察对象无效时，InvalidationListener就会得到通知。它可以在Observable#addListener(InvalidationListener)中注册，也可以在Observable#removeListener(InvalidationListener)中不注册。要深入解释失效事件及其与更改事件的区别，请参阅ObservableValue的文档。InvalidationListener的同一个实例可以注册为监听多个可观察对象
			@interface	NamedArg 提供有关参数名称的信息的注释
			interface Observable	可观察对象是一个实体，它封装内容并允许观察失效的内容。Observable的实现可能支持延迟计算，这意味着内容不会在更改之后立即重新计算，而是在下一次请求时延迟计算。这个库中的所有绑定和属性都支持延迟计算。该类的实现应该尽量少生成事件，以避免在事件处理程序中浪费太多时间。当第一个失效事件发生时，这个库中的实现将自己标记为无效。在重新计算它们的值并再次有效之前，它们不会生成任何失效事件。
			class WeakInvalidationListener	如果观察到的对象只维护对侦听器的弱引用，则可以使用WeakInvalidationListener。这有助于避免内存泄漏，如果在使用后未从观察对象中注销观察者，则可能发生内存泄漏。WeakInvalidationListener是通过传入原始InvalidationListener创建的。然后应该注册WeakInvalidationListener来侦听所观察对象的更改。注意:您必须保留对InvalidationListener的引用，该引用在使用期间一直传递给InvalidationListener，否则它可能会很快被垃圾收集。
			interface WeakListener	WeakListener是JavaFX API中所有弱侦听器实现的超级接口。通常不应该直接使用它，而是使用其中一个子接口。
	javafx.controls	定义可用的UI控件、图表和皮肤用于JavaFX UI工具包
		scene.chart
			control
			cell
			skin
	javafx.fxml	为JavaFX UI工具包定义FXML api
		fxml
	javafx.graphics	为JavaFX UI工具包定义核心scenegraph api(例如布局容器、应用程序生命周期、形状、转换、画布、输入、绘画、图像处理和效果)，以及用于动画、css、并发、几何、打印和的api窗口
		animation	动画
		application	应用
			class Application	JavaFX应用程序扩展的应用程序类
			enum ConditionalFeature	定义一组条件(可选)特性。这些特性可能不是在所有平台上都可用。想要知道某个特定特性是否可用的应用程序可以使用Platform#isSupported(javafx.application.ConditionalFeature) Platform.isSupported()函数查询。在不支持条件特性的平台上使用条件特性不会导致异常。通常，条件特性将被忽略。
			class HostServices	该类为应用程序提供主机服务。这包括获取应用程序的代码库和文档库，以及在浏览器中显示web页面的方法
			class Platform	应用平台支持类
			class Preloader	扩展该类以定义JavaFX应用程序的可选预加载器。应用程序可能包含用于改进应用程序加载体验的预加载器。
		concurrent	并发
		css	层叠样式表
			converter
		geometry	几何结构
		print	打印
		scene	场景
			canvas
			effect
			image
			input
			layout
			paint
			robot
			shape
			text
			transform
		stage	舞台
			class DirectoryChooser	提供对标准目录选择器对话框的支持。这些对话框具有独立于JavaFX的平台UI组件的外观和感觉。在某些平台上，文件访问可能受到限制，也可能不是用户模型的一部分(例如，在一些移动或嵌入式设备上)，打开目录对话框可能总是导致no-op(即返回空文件)
			class FileChooser	提供对标准平台文件对话框的支持。这些对话框具有独立于JavaFX的平台UI组件的外观和感觉。在某些平台上，文件访问可能受到限制，也可能不是用户模型的一部分(例如，在一些移动设备或嵌入式设备上)，打开文件对话框可能总是导致no-op(即返回空文件)
			enum Modality	这个枚举定义了Stage可能的模式类型
			class Popup	弹出窗口是一个特殊的窗口状容器，用于场景图。它通常用于通知、下拉框、菜单等工具提示。弹出窗口没有任何修饰，本质上充当一个没有修饰的特殊场景/窗口，是透明的，并且填充为空。
			class PopupWindow	PopupWindow是基于弹出窗口的各种不同类型的父窗口，包括popup和Tooltip以及ContextMenu
			class Screen	描述图形目标(如监视器)的特征。在虚拟设备多屏幕环境中，桌面区域可以跨多个物理屏幕设备，屏幕对象的边界相对于screen .primary
			class Stage	Stage类是顶级JavaFX容器。初级阶段由平台构成。应用程序可以构造其他阶段对象。必须在JavaFX应用程序线程上构造和修改Stage对象。
	javafx.media	定义用于播放媒体和音频内容的api，作为JavaFX UI工具包的一部分，包括MediaView和MediaPlayer
		scene.media
	javafx.swing	为JavaFX UI工具包中包含的JavaFX / Swing互操作支持定义api，包括SwingNode(用于在JavaFX应用程序中嵌入Swing)和JFXPanel(用于在Swing应用程序中嵌入JavaFX)
	javafx.web	方法中包含的WebView功能定义api JavaFX UI工具包
		scene.web