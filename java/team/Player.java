package team;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity 
public class Player {
	
	public static class Builder {
		
		private Integer id;

		private String name;

		private String lastName;

		private int age;

		private String position;

		private Long price;
		
		private Club club;

		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setPosition(String position) {
			this.position = position;
			return this;
		}

		public Builder setPrice(Long price) {
			this.price = price;
			return this;
		}
		
		public Builder setClub(Club club) {
			this.club = club;
			return this;
		}
		

        public Player build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
        	Player player = new Player();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            player.age = this.age;
            player.id = this.id;
            player.lastName = this.lastName;
            player.name = this.name;
            player.position = this.position;
            player.price = this.price;
            player.club = this.club;
            return player;
        }
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	private String name;

	private String lastName;

	private int age;

	private String position;

	private Long price;
	
	@ManyToOne
	@JoinColumn(name="club_id")
	private Club club;
	
	public Club getClub() {
		return club;
	}

	public void setTClub(Club club) {
		this.club = club;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}
	

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", position=" + position
				+ ", price=" + price + "]";
	}


}