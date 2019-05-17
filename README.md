
# 高仿知乎 实现单个Activity对应多个fragment 

#          getChildFragmentManager（）的定义是： 返回一个私有FragmentManager，用于放置和管理Fragment中的Fragment。
# 
#         同时getFragmentManager（）的定义是： 返回FragmentManager以与片段活动关联的片段进行交互。
# 
#         基本上，区别在于Fragment现在有自己的内部FragmentManager可以处理Fragments。子FragmentManager是处理仅包含在它所添加的Fragment中的Fragments的子类。另一个FragmentManager包含在整个Activity中。
# 
#         要在MainActivity上显示Fragment1，我们必须使用getSupportFragmentManager（）
# 
#         getSupportFragmentManager().beginTransaction().replace(R.id.container_view_on_main, Fragment1.newInstance());
#         要从Fragment1显示Fragment2，我们有两种方式
# 
#         使用getFragmentManager（）
# 
#         getFragmentManager().beginTransaction().replace(R.id.container_view_on_main, Fragment1.newInstance());
#         使用getChildFragmentManager（）
# 
#         首先，我们必须在fragment1.xml中创建一个id为container_view_on_fragment1的布局
# 
#         getChildFragmentManager().beginTransaction().replace(R.id.container_view_on_fragment1, Fragment2.newInstance()).commit();

      

Activity切换 效果图

![image](https:# github.com/qianxiangsen521/appStore/blob/master/image/etpsb-st00a.gif) 


