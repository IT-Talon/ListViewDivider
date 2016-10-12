# ListViewDivider
关于listview的分割线显示

今天发现许多App上的listview的item之间的分割线都只显示了右边一部分，而左边的那一半则没有，第一反应则是给分割线设置一张背景图片就ok了：

android:divider="@mipmap/line"

然而，后来网上找找资料后发现，可以自己去定义一个drawable,将其设置为listview的分割线（divider）

效果图：




1.drawable下的listview_item_divider:
复制代码
1 <?xml version="1.0" encoding="utf-8"?>
2 <inset xmlns:android="http://schemas.android.com/apk/res/android"
3     android:insetLeft="100dp"
4     android:insetRight="15dp"
5     android:drawable="@color/line_gray">
6 
7 </inset>
复制代码
2.activity_main里的listview:

复制代码
1 <ListView
2 
3         android:id="@+id/lv_main"
4         android:divider="@drawable/listview_item_divider"
5         android:dividerHeight="1dp"
6         android:layout_width="match_parent"
7         android:layout_height="match_parent">
8 </ListView>
复制代码
3.item布局：

复制代码
 1 <?xml version="1.0" encoding="utf-8"?>
 2 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 3     android:layout_width="match_parent"
 4     android:layout_height="wrap_content"
 5     android:orientation="horizontal"
 6     android:padding="3dp">
 7 
 8     <ImageView
 9         android:id="@+id/img_item"
10         android:layout_width="100dp"
11         android:layout_height="100dp"
12         android:contentDescription="@null"
13         android:scaleType="fitXY"
14         android:src="@mipmap/octocat" />
15 
16     <TextView
17         android:id="@+id/tv_item"
18         android:layout_width="match_parent"
19         android:layout_height="100dp"
20         android:gravity="center"
21         android:text="TITLE"
22         android:textSize="15sp" />
23 
24 </LinearLayout>
复制代码
4.MainActivity（由于比较简单，所以并没有严格规范编码格式）

复制代码
 1 public class MainActivity extends AppCompatActivity {
 2 
 3     private ListView mListView;
 4 
 5     @Override
 6     protected void onCreate(Bundle savedInstanceState) {
 7         super.onCreate(savedInstanceState);
 8         setContentView(R.layout.activity_main);
 9         mListView = (ListView) findViewById(R.id.lv_main);
10         // 为listview设置数据（没有改变图片，仅仅设置了不同的title）
11         List<Map<String, String>> list = new ArrayList<>();
12         for (int i = 0; i < 20; i++) {
13             Map<String, String> map = new HashMap<>();
14             map.put("title", "Talon" + i);
15             list.add(map);
16         }
17         SimpleAdapter adapter = new SimpleAdapter(this, list,
18                 R.layout.listview_item, new String[]{"title"},
19                 new int[]{R.id.tv_item});
20         mListView.setAdapter(adapter);
21     }
22 }
复制代码
关于文中不好的地方，欢迎各位批评指正！
