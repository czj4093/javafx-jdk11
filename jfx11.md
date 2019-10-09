# javafx.base
定义JavaFX UI工具包的基本api，包括用于绑定、属性、集合和事件
## beans
### binding
### property
#### adapter
### value
### collections
#### transformation
### event
### util
#### converter
**@interface	DefaultProperty**
 
指定将向其添加或设置子元素的属性没有给出显式属性

**interface	InvalidationListener**
	
当观察对象无效时，InvalidationListener就会得到通知。它可以在Observable#addListener(InvalidationListener)中注册，也可以在Observable#removeListener(InvalidationListener)中不注册。要深入解释失效事件及其与更改事件的区别，请参阅ObservableValue的文档。InvalidationListener的同一个实例可以注册为监听多个可观察对象

**@interface	NamedArg**
 
提供有关参数名称的信息的注释

**interface Observable**
	
可观察对象是一个实体，它封装内容并允许观察失效的内容。Observable的实现可能支持延迟计算，这意味着内容不会在更改之后立即重新计算，而是在下一次请求时延迟计算。这个库中的所有绑定和属性都支持延迟计算。该类的实现应该尽量少生成事件，以避免在事件处理程序中浪费太多时间。当第一个失效事件发生时，这个库中的实现将自己标记为无效。在重新计算它们的值并再次有效之前，它们不会生成任何失效事件。

**class WeakInvalidationListener**
	
如果观察到的对象只维护对侦听器的弱引用，则可以使用WeakInvalidationListener。这有助于避免内存泄漏，如果在使用后未从观察对象中注销观察者，则可能发生内存泄漏。WeakInvalidationListener是通过传入原始InvalidationListener创建的。然后应该注册WeakInvalidationListener来侦听所观察对象的更改。注意:您必须保留对InvalidationListener的引用，该引用在使用期间一直传递给InvalidationListener，否则它可能会很快被垃圾收集。

**interface WeakListener**	

WeakListener是JavaFX API中所有弱侦听器实现的超级接口。通常不应该直接使用它，而是使用其中一个子接口。
# javafx.controls	
定义可用的UI控件、图表和皮肤用于JavaFX UI工具包
## scene.chart
### control
### cell
### skin
# javafx.fxml	
为JavaFX UI工具包定义FXML api
## fxml
# javafx.graphics	
为JavaFX UI工具包定义核心scenegraph api(例如布局容器、应用程序生命周期、形状、转换、画布、输入、绘画、图像处理和效果)，以及用于动画、css、并发、几何、打印和的api窗口
## animation	动画
## application	应用
**class Application**	

JavaFX应用程序扩展的应用程序类

**enum ConditionalFeature**

定义一组条件(可选)特性。这些特性可能不是在所有平台上都可用。想要知道某个特定特性是否可用的应用程序可以使用Platform#isSupported(javafx.application.ConditionalFeature) Platform.isSupported()函数查询。在不支持条件特性的平台上使用条件特性不会导致异常。通常，条件特性将被忽略。

**class HostServices**	

该类为应用程序提供主机服务。这包括获取应用程序的代码库和文档库，以及在浏览器中显示web页面的方法

**class Platform**	

应用平台支持类

**class Preloader**	

扩展该类以定义JavaFX应用程序的可选预加载器。应用程序可能包含用于改进应用程序加载体验的预加载器。
## concurrent	并发
## css	层叠样式表
### converter
## geometry	几何结构
## print	打印
## scene	场景
**enum AccessibleAction**	

该枚举描述了辅助技术的作用 例如屏幕阅读器可以从场景图中请求

**enum AccessibleAttribute**	

此枚举描述辅助技术的属性 例如屏幕阅读器可以从场景图中请求

**enum AccessibleRole**	

这个枚举描述了Node的可访问角色

**class AmbientLight**	

定义环境光源对象。环境光是一种光源那似乎来自四面八方

**enum CacheHint**

与Node.cacheHint一起使用的缓存提示

**class Camera**

用于渲染场景的摄像机的基类。摄像机定义场景坐标空间到窗口的映射。Camera是一个抽象类，有两个具体子类:ParallelCamera和PerspectiveCamera

**class CssStyleHelper**

StyleHelper是一个帮助类，用于将CSS信息应用于节点

**class Cursor**

一个类，用于封装鼠标指针的位图表示

**enum DepthTest**

这个enum为node中的depthTest标志定义了可能的状态

**class Group**

Group节点包含子节点的ObservableList，这些子节点在每次呈现时都按顺序呈现。一个Group将承担其子组的集体界限，并且不能直接调整大小

**class ImageCursor**

鼠标光标的自定义图像表示。在不支持自定义游标的平台上使用游标。默认值将代替指定的ImageCursor

**class LightBase**

LightBase类为表示光源形式的对象提供公共属性的定义。这些属性包括:定义光源颜色的颜色

**class Node**

场景图节点的基类。场景图是一组树状数据结构，其中每个项都有0个或一个父项，每个项要么是一个包含0个子项的“叶子”，要么是一个包含0个或多个子项的“分支”

**class ParallelCamera**

指定用于呈现没有透视校正的场景的并行摄像机

**class Parent**

场景图中包含子节点的所有节点的基类

**class PerspectiveCamera**

指定用于呈现场景的透视图摄像机

**class PointLight**

定义一个点光源对象。一种光源，它在空间中有一个固定点，并向远离自身的所有方向均匀地辐射光

**class PropertyHelper**

系统属性帮助类

**class Scene**

场景类是场景图中所有内容的容器。场景的背景由fill属性指定填充

**class SceneAntialiasing**

SceneAntialiasing类指定所需的抗锯齿级别。场景反混叠主要用于渲染3D原语，否则将呈现混叠

**class SnapshotParameters**

参数，用于指定节点快照的呈现属性

**class SnapshotResult**

该类保存快照操作的结果

**class SubScene**

子场景类是场景图中内容的容器。子场景提供了场景的不同部分的分离，每个部分都可以使用不同的摄像机、深度缓冲区或场景抗混叠来呈现。子场景嵌入到主场景或其他子场景中

### canvas 画布
**class Canvas**

Canvas是可以使用GraphicsContext提供的一组图形命令在上面绘制的图像

**class GraphicsContext**

该类用于使用缓冲区向画布发出绘制调用。每次调用都将必要的参数推入缓冲区，然后在脉冲结束时由呈现线程将这些参数呈现到画布节点的图像上

### effect 材质
### image 图像
### input 输入
### layout 布局
**class public class AnchorPane extends Pane**

AnchorPane允许将子节点的边缘锚定到AnchorPane边缘的偏移量上。如果AnchorPane设置了边框和/或填充，则偏移量将从这些嵌入的内边缘测量。AnchorPane列出每个托管子节点，而不考虑子节点的可见属性值;所有布局计算都忽略非托管子元素。AnchorPane可以使用CSS设置背景和边框样式。有关详细信息，请参见Region超类

public AnchorPane()
public AnchorPane(Node... children)

public static void setTopAnchor(Node child, Double value)
public static Double getTopAnchor(Node child)
public static void setLeftAnchor(Node child, Double value)
public static Double getLeftAnchor(Node child)
public static void setBottomAnchor(Node child, Double value)
public static Double getBottomAnchor(Node child)
public static void setRightAnchor(Node child, Double value)
public static Double getRightAnchor(Node child)
public static void clearConstraints(Node child)

@Override protected double computeMinWidth(double height)
@Override protected double computeMinHeight(double width)
@Override protected double computePrefWidth(double height)
@Override protected double computePrefHeight(double width)
@Override protected void layoutChildren()

private double computeWidth(final boolean minimum, final double height)
private double computeHeight(final boolean minimum, final double width)
private double computeChildWidth(Node child, Double leftAnchor, Double rightAnchor, double areaWidth, double height)
private double computeChildHeight(Node child, Double topAnchor, Double bottomAnchor, double areaHeight, double width)

**class Background**

一个Region的背景。背景是一个不可变的对象，它封装了呈现Region背景所需的全部数据集。因为这个类是不可变的，所以您可以在许多不同的Region上自由地重用相同的背景。

**class BackgroundConverter**

将-fx-background项的CSS转换为背景

**class BackgroundFill**

指示如何填充Region背景的填充和关联属性。因为BackgroundFill是一个不可变的对象，所以它可以安全地在任何缓存中使用，并且可以安全地在多个Region之间或同一Region内多次重用。所有的背景填充物都是按顺序绘制的。当应用于具有定义形状的Region时，角半径将被忽略

**class BackgroundImage**

定义描述如何将图像呈现为某个Region的背景的属性。BackgroundImage必须指定一个图像(不能为空)。#getRepeatX() repeatX和#getRepeatY() repeatY属性定义了如何在每个方向上重复图像。位置属性定义如何在区域上定位图像，而getSize() size属性定义图像在区域上的大小。例如，size可以使用BackgroundSize#isCover() cover = true来定义，这意味着应该拉伸图像以覆盖Region的整个呈现表面。因为BackgroundImage是不可变的，所以可以安全地在任何缓存中使用它，也可以安全地在多个Region之间重用它

**class BackgroundPosition**

表示BackgroundImage在Region绘图区域中的位置

**enum BackgroundRepeat**

枚举用于在背景中重复图像的选项

**class BackgroundSize**

定义BackgroundImage相对于其样式化的区域应该填充的区域的大小。有几个属性的值优先于其他属性。特别是有4个关键属性，宽度、高度、包含和覆盖。宽度和高度都是相互独立的，但是它们都与包容和覆盖相互作用

**class Border**

一个Region的边界。边界是一个不可变的对象，它封装了呈现Region边界所需的全部数据集。因为这个类是不可变的，所以您可以在许多不同的Region上自由地重用相同的边界

**class BorderConverter**

将-fx-border项的CSS转换为边界

**class BorderImage**

定义属性，描述如何将图像呈现为某个区域的边框。边界映像必须指定一个映像(不能为空)。repeatX和repeatY属性定义了如何在每个方向上重复图像。slice属性定义了如何对图像进行切片，使其可以在区域内进行拉伸，而width则定义了区域上要填充边框图像的区域。最后，这些偏移量定义了边界延伸到边界边缘的距离。BorderImage的偏移量对边界的偏移量有贡献，而边界的偏移量又对区域的边界有贡献

**class BorderPane**

BorderPane将子元素放在顶部、左侧、右侧、底部和中心位置。显示每个子元素位置的图表顶部和底部的子元素将被调整到它们喜欢的高度并扩展边框窗格的宽度。左
子节点和右子节点的大小将调整到它们喜欢的宽度，并扩展顶部和底部节点之间的长度。中心节点将被调整大小，以填充中间的可用空间。任何位置都可以为空

**enum BorderRepeat**

表示边框图像的重复规则

**class BorderStroke**

定义边框上用于样式化区域的笔画。描边是一种基于矢量的绘制，它勾勒出边界区域。它可以从区域的边缘插入(或开始)，并且在计算区域的插入(用于定义内容区域)时
考虑笔画的值。在使用边界图像时不使用笔画视觉效果

**class BorderStrokeStyle**

定义边框一侧使用的边框样式。有几种预定义的样式，尽管这些预定义样式的属性可能与最终用于绘制它们的设置不匹配。或者您可以创建一个新的
BorderStrokeStyle并手动定义每个笔画设置，类似于任何形状

**class BorderWidths**

定义四个组件(顶部、右侧、底部和左侧)的宽度。每个宽度都被定义为非负的值，这个值可以解释为文字值，也可以解释为区域宽度或高度的百分比，具体取决于
topaspercent、rightaspercent、bottom aspercent和leftaspercent的值。对于顶部、右侧、底部和左侧，唯一允许的负值是AUTO

**class ColumnConstraints**

定义grid窗格中列的可选布局约束。如果为gridpane中的列添加ColumnConstraints对象，gridpane将在计算列的宽度和布局时使用这些约束值

**class ConstraintsBase**

用于定义特定于节点的布局约束的基类。区域类可以创建该类的扩展，如果它们需要定义自己的一组布局约束

**class CornerRadii**

定义边框的每个角的半径。CornerRadii类是不可变的，因此可以在多个边界笔画上重用。这个类定义了8个不同的值，对应于4个四分之一椭圆的水平和垂直分量，
这些分量反过来定义边界笔划角的曲率

**class FlowPane**

FlowPane在一个流中展开它的子流，该流在FlowPane的边界处进行包装。水平的flowpane(默认值)将按行布局节点，以flowpane的宽度进行包装。垂直的
flowpane以列的形式布局节点，以flowpane的高度进行包装。如果flowpane有一个边框和/或填充设置，内容将在这些insets中流动。

**class GridPane**

GridPane将它的子元素放在一个由行和列组成的灵活网格中。如果设置了边框和/或内边距，则其内容将在这些insets中布局。子元素可以放在网格中的任何位置，并
且可以跨多行/多列。子元素可以在行/列中自由重叠，它们的堆叠顺序将由gridpane的子元素列表的顺序定义(第0个节点在后面，最后一个节点在前面)。

**class HBox**

HBox将它的子元素放在一个水平的行中。如果hbox设置了边框和/或填充，那么内容将被放置在那些insets里。

**public class Pane extends Region**

需要将子列表公开为公共的布局窗格的基类以便子类的用户可以自由添加/删除子类。如果需要对子元素进行绝对定位，则可以直接使用该类，因为该类只执行将可调整大
小的子元素调整为其首选大小之外的布局。应用程序的职责是定位子元素，因为窗格在布局期间不显示位置。

static void setConstraint(Node node, Object key, Object value)
static Object getConstraint(Node node, Object key)

public Pane()
public Pane(Node... children)

@Override public ObservableList<Node> getChildren()

**enum Priority**

枚举，用于确定给定节点布局区域的增长(或收缩)优先级，当该区域可用空间更多(或更少)且多个节点竞争该空间时。

**class Region**

Region是所有基于JavaFX节点的UI控件和所有布局容器的基类。它是一个可调整大小的父节点，可以从CSS样式。它可以有多个背景和边框。它的设计目的是支持与
JavaFX相关的尽可能多的CSS3背景和边框规范。

**class RowConstraints**

为GridPane中的行定义可选布局约束。如果为gridpane中的行添加了RowConstraints对象，gridpane将在计算行高度和布局时使用这些约束值。

**class StackPane**

StackPane将它的子元素放在一个前后颠倒的堆栈中。子元素的z顺序由子元素列表的顺序定义，其中第0个子元素位于底部，最后一个子元素位于顶部。如果设置了边框
和/或内边距，子元素将被放置在这些嵌套中。stackpane将尝试调整每个子元素的大小，以填充其内容区域。如果无法调整子元素的大小来填充stackpane(要么是因
为它无法调整大小，要么是因为它的最大大小阻止了它)，那么它将使用align属性在该区域内对齐，该属性默认为Pos.CENTER。

**class TilePane**

TilePane将它的子元素放置在一个由大小相同的“tile”组成的网格中。水平窗格(默认)将按行平铺节点，以平铺窗格的宽度进行包装。垂直的窗格将在列中平铺节点，
以窗格的高度包装。

**class VBox**

VBox将它的子元素放在一个单独的垂直列中。如果vbox有一个边框和/或内边距设置，那么内容将被放置在这些内边距中。

### paint 画图
### robot 机器人
**class Robot**

机器人用于模拟用户交互，例如在键盘上键入键和使用鼠标，以及不需要. scene实例就可以捕获图形信息。机器人对象必须在JavaFX应用程序线程上构造和使用
### shape 形状
### text 文本
### transform 转换
## stage	舞台
class DirectoryChooser	

提供对标准目录选择器对话框的支持。这些对话框具有独立于JavaFX的平台UI组件的外观和感觉。在某些平台上，文件访问可能受到限制，也可能不是用户模型的一部分(例如，在一些移动或嵌入式设备上)，打开目录对话框可能总是导致no-op(即返回空文件)

class FileChooser	

提供对标准平台文件对话框的支持。这些对话框具有独立于JavaFX的平台UI组件的外观和感觉。在某些平台上，文件访问可能受到限制，也可能不是用户模型的一部分(例如，在一些移动设备或嵌入式设备上)，打开文件对话框可能总是导致no-op(即返回空文件)

enum Modality	

这个枚举定义了Stage可能的模式类型

class Popup	

弹出窗口是一个特殊的窗口状容器，用于场景图。它通常用于通知、下拉框、菜单等工具提示。弹出窗口没有任何修饰，本质上充当一个没有修饰的特殊场景/窗口，是透明的，并且填充为空。

class PopupWindow	

PopupWindow是基于弹出窗口的各种不同类型的父窗口，包括popup和Tooltip以及ContextMenu

class Screen	

描述图形目标(如监视器)的特征。在虚拟设备多屏幕环境中，桌面区域可以跨多个物理屏幕设备，屏幕对象的边界相对于screen .primary

class Stage	

Stage类是顶级JavaFX容器。初级阶段由平台构成。应用程序可以构造其他阶段对象。必须在JavaFX应用程序线程上构造和修改Stage对象。

enum StageStyle	

这个enum为Stage定义了可能的样式

class Window	

一个顶层窗口，其中承载场景，并与用户交互。一个窗口可能是一个舞台，弹出窗口，或其他这样的顶层窗口

class WindowEvent	

与窗口显示/隐藏操作相关的事件
# javafx.media	
定义用于播放媒体和音频内容的api，作为JavaFX UI工具包的一部分，包括MediaView和MediaPlayer
## scene.media
# javafx.swing	
为JavaFX UI工具包中包含的JavaFX / Swing互操作支持定义api，包括SwingNode(用于在JavaFX应用程序中嵌入Swing)和JFXPanel(用于在Swing应用程序中嵌入JavaFX)
# javafx.web	
方法中包含的WebView功能定义api JavaFX UI工具包
## scene.web