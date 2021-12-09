코인일기 프로젝트의 가장 기본적인 조회, 저장 로직 구현은 아래처럼 해주었다.

#### EntityManager 사용예

**DiaryController**

```java
package com.coin.diary.controller;
...

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
  ...
	
	@RequestMapping(value="saveDiary", method = {RequestMethod.POST})
	public String savedDiary(Diary diary, RedirectAttributes ra) {		
		diaryService.save(diary);
		ra.addAttribute("writeDt", diary.getWriteDt());
		return "redirect:/diaryList";
	}
	
	@RequestMapping(value="diaryList", method = {RequestMethod.GET})
	public String getDiaryList(@RequestParam("writeDt") @Nullable String writeDt, Model model) {  
		model.addAttribute("diaryList", diaryService.find(writeDt));
		return "diaryList";
	}
}
```

**EntityManagerUtils**

```java
package com.coin.diary;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
	
	private static EntityManagerFactory emf;
	private EntityManagerUtils() {}
	
	public static synchronized EntityManagerFactory getInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
		}
		return emf;
	}
}
```

위와같이 EntityManagerUtils 클래스를 두고, EntityManagerFactory 객체를 한개만 생성하도록 하고(싱글톤)

**DiaryService, DiaryServiceImpl**

```java
public interface DiaryService {
	public List<Diary> findAll();
	public Diary find(String writeDt);
	public void save(Diary diary);
}


@Service
public class DiaryServiceImpl implements DiaryService{

	EntityManager em = EntityManagerUtils.getInstance().createEntityManager();
	
	@Override
	public List<Diary> findAll() {
		// TODO Auto-generated method stub
		...
	}

	@Override
	public Diary find(String writeDt) {
		// TODO Auto-generated method stub
		return em.find(Diary.class, writeDt);
	}

	@Override
	public void save(Diary diary) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(diary);
		em.getTransaction().commit();
	}
}
```

ServiceImpl 클래스에서 EntityManagerUtils클래스의 getInstance 를 통해, 엔티티매니저 팩토리 객체를 얻도록 하였다. 해당 객체를 통해 EntityManager를 만든다.

기본적인 save, find 메소드를 EntityManager를 통해 구현하였다.



#### JpaRepository 사용예

spring-pet-clinic 프로젝트를 받아서 까보니, spring-data-jpa 라이브러리에서 제공하는 Repository<T id> 를 통해 데이터 조회, 저장을 구현해주고 있었다.

EntityManager를 통해 persist, find 메소드를 사용하여 직접 데이터를 핸들링하는 방식도 있지만, Jpa의 Repository 인터페이스를 통해서는 훨씬 편하게 CRUD를 구현해줄 수 있었다.

```java
package com.coin.diary.repository;

...

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, String>{
	List<Diary> findByWriteDt(String writeDt);
}
```

위처럼 DiaryRepository라는 커스텀 Repository 인터페이스를 생성하고, Repository<T id> 의 구현체인 JpaRepsitory 를 상속받도록 구현한다. 

JpaRepository의 T 부분은 Entity 클래스, id 부분은 어떤 타입이 해당 엔티티의 Id속성인지를 설정해주면 된다. Diary엔티티의 경우, String 타입의 writeDt 가 Id 이므로, JpaRepository<Diary, String> 으로 지정해주었다.

JapRepository에 구현되어 있는 메소드들은 아주 많은데, 기본적으로 findAll, save 등의 메소드들이 존재한다. 뿐만 아니라,

Controller 부에서는 DiaryRepository 객체를 주입받고 데이터를 저장, 조회가능하다.

```java
@Autowired
DiaryRepository diaryRepository;

@RequestMapping(value="diaryList", method = {RequestMethod.GET})
	public String getDiaryList(@RequestParam("writeDt") @Nullable String writeDt, Model model) {  
		List<Diary> diary = diaryRepository.findAll();	
		model.addAttribute("diaryList", diaryRepository.findAll());
		return "diaryList";
	}
```

