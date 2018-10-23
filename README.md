# Recycler View

### 동작 시현
![](/screenshot/recycler_view_test.gif)

* RecyclerView는 ListView에서 Holder를 사용하던 개념을 추가하여 만들어놓은 List이다.
* 사용법은 ListView기반에서 Holder를 사용하는 방법과 유사한 구조로 구현은 비교적 더 간단하다.

### 구현 순서
1. RecyclerView.RecyclerView.Adapter<VH> 를 상속하여 CustomAdapter를 정의한다.
2. RecyclerView.ViewHolder 를 상속한 ViewHolder를 정의한다.
3. 리스트에서 사용될 데이터를 가져오기 위해 DAO 클래스를 설계한다.
4. RecyclerView의 어댑터를 설정한다.
5. RecyclerView의 레이아웃을 설정한다.

* 자동차 목록을 보여주기 위해 자동차 DAO 클래스를 설계하여 사용하였다.
````java
 recyclerview = findViewById(R.id.recyclerView);
 CarDao dao = new CarDao(this);
 CustomAdapter adapter = new CustomAdapter(this, dao.getDao());
 recyclerview.setAdapter(adapter);
 recyclerview.setLayoutManager(new LinearLayoutManager(this));
````
<br>

---
#### CustomAdapter 정의
* 3개의 메소드가 필수적으로 오버라이딩 되어야한다.
* createViewHolder 메소드는 리스트 아이템 생성시 한번만 호출되는 메소드로 LayoutInfalter를 사용하여 infalting된 View객체를 Holder 클래스의 생성자에 넣어 생선된 Holder 객체를 반환해줘야 한다.
* onBindViewHolder 메소는 ListView에서 storedView처럼 안드로이드에서 리스트 아이템의 Holder를 넘겨준다.
* getItemCount는 데이터 목록의 총 개수를 반환해줘야 한다.
````java
class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
      return 0;
    }
}
````

<br>

---
#### ViewHolder를 Inner Class로 정의
* ViewHolder는 생성자가 필수로 정의되어야 하며, ListView의 Holder를 사용하는법과 유사하다.
````java
class Holder extends RecyclerView.ViewHolder {
      public Holder(@NonNull View itemView) {
        super(itemView);
      }
}
````

<br>

---
#### DAO 설계
* Data 클래스로 사용할 Car 클래스를 정의한다.
````java
class Car {
  int imgId;
  String name;
  String company;
}
````

<br>

---
* 임의로 Car 인스턴스를 생성한다. 여기서는 100개의 인스턴스를 생성하였다.
* 이미지는 ImageView에서 바로 사용할 수 있도록 MainActivity로부터 Context 객체를 가져와 이미지의 리소스ID를 만들어 변수에 할당해 주었다.
* 만들어진 Car 인스턴스는 리스트에 추가하여 최종으로 리스트를 반환해준다.
````java
public class CarDao {
  List<Car> list = new ArrayList<>();
  Context ctx;

  public CarDao(Context ctx) {
    this.ctx = ctx;
  }

  List<Car> getDao() {
      car.imgId = ctx.getResources().getIdentifier(carName, "drawable", ctx.getPackageName());

      list.add(car);
    }

    return list;
  }
}
````
<br>

---
#### Layout Manager
* RecyclerView 의 특징으로 레이아웃 매니저를 사용하여 레이아웃을 지정해주면 원하는 형태로 리스트를 볼 수 있다.
* LinearLayoutManager를 지정하여 앱에서 흔히 볼 수 있는 형태의 상하로 스크롤링 되는 형태의 레이아웃을 지정해주었다.

