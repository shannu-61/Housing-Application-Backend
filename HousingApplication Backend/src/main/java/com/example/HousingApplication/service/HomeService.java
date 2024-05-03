package com.example.HousingApplication.service;
import com.example.HousingApplication.model.Home;
import com.example.HousingApplication.repository.AddressRepository;
import com.example.HousingApplication.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@org.springframework.stereotype.Service
public class HomeService {

	@Autowired
	private HomeRepository homeRepository;

	@Autowired
	private AddressRepository addressRepository;


	public List<Home> homesUnderBudget(double price)
	{
		return homeRepository.findByPriceLessThan(price);
	}

//	public void importData()
//	{
//		List<List<String>> res = new ArrayList();
//		try(BufferedReader fileReader
//		        = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/data.csv"))))
//		{
////			new FileReader("/data.csv")
//		  String line = "";
//
//		  while ((line = fileReader.readLine()) != null)
//		  {
//		    String[] tokens = line.split(",");
//		    List<String>temp = new ArrayList();
//		    for(String s:tokens)
//		    {
//		    	temp.add(s);
//		    }
//		    res.add(temp);
//		  }
//		  for(int j=1;j<res.size();++j)
//		  {
//			double price = Double.parseDouble(res.get(j).get(1));
//			double bedrooms = Double.parseDouble(res.get(j).get(2));;
//			double bathrooms = Double.parseDouble(res.get(j).get(3));;
//			long sqft_living = Long.parseLong(res.get(j).get(4));
//			long sqft_lot = Long.parseLong(res.get(j).get(5));;
//			double floors = Double.parseDouble(res.get(j).get(6));
//			int waterfront = Integer.parseInt(res.get(j).get(7));
//			int view = Integer.parseInt(res.get(j).get(8));
//			int condition = Integer.parseInt(res.get(j).get(9));
//			long sqft_above = Long.parseLong(res.get(j).get(10));;
//			long sqft_basement = Long.parseLong(res.get(j).get(11));;
//			int yr_built = Integer.parseInt(res.get(j).get(12));
//			int yr_renovated = Integer.parseInt(res.get(j).get(13));
//
//			String street = res.get(j).get(14);
//			String city = res.get(j).get(15);
//			String statezip = res.get(j).get(16);
//			String country = res.get(j).get(17);
//
//			Address address = new Address();
//			address.setCity(city);
//			address.setCountry(country);
//			address.setStatezip(statezip);
//			address.setStreet(street);
//
//			Home home = Home.builder().bathrooms(bathrooms)
//					.bedrooms(bedrooms).condition(condition).floors(floors).price(price)
//					.sqft_above(sqft_above).sqft_basement(sqft_basement).sqft_living(sqft_living)
//					.sqft_lot(sqft_lot).view(view).waterfront(waterfront).yr_built(yr_built)
//					.yr_renovated(yr_renovated)
//					.address(address).build();
//
//			Home h = homeRepository.save(home);
////			System.out.println(h);
//		  }
//
//		}
//		catch (IOException e) {
//		  e.printStackTrace();
//		}
//	}

	public Home create(Home home) {
		return homeRepository.save(home);
		}

	public List<Home> getAllHomes() {
		return homeRepository.findAll();
	}

	public void deleteHomeById(Long houseId) {

		Optional<Home> h = homeRepository.findByHouseId(houseId);
		if(h.isPresent())
			homeRepository.delete(h.get());
	}

	public Home updateHomeById(Long houseId, Home home) {
		Optional<Home> h = homeRepository.findByHouseId(houseId);
		if(h.isPresent())
		{
			if(h.get().getHouseId() == home.getHouseId())
				homeRepository.save(home);
		}
		return h.get();
	}

	public Optional<Home> fetchHomeById(Long houseId) {
		return homeRepository.findByHouseId(houseId);
	}
	public List<Home> getHomesByCity(String city) {
		return homeRepository.findByAddress_City(city);
	}
	// In HomeService
	public List<Home> getHomesByBedroomsAndBathrooms(double bedrooms, double bathrooms) {
		return homeRepository.findByBedroomsAndBathrooms(bedrooms, bathrooms);
	}


	public List<Double> getHistoricalData() {
		List<Double> historicalPrices = new ArrayList<>();

		// Simulating historical data for the past 12 years
		int currentYear = Year.now().getValue();
		for (int i = currentYear - 12; i < currentYear; i++) {
			double price = generateRandomPrice(); // Replace with your logic to generate prices
			historicalPrices.add(price);
		}

		return historicalPrices;
	}

	private double generateRandomPrice() {
		double minPrice = 1000;
		double maxPrice = 2000;
		return minPrice + (maxPrice - minPrice) * Math.random();
	}

	// ... other existing methods ...


	public List<Double> getFutureTrends() {

		List<Double> futurePrices = new ArrayList<>();

		// Generate mock future trends
		Random random = new Random();
		for (int i = 0; i < 12; i++) {
			double price = 1500 + random.nextDouble() * 500; // Mock prices between 1500 and 2000
			futurePrices.add(price);
		}

		return futurePrices;
	}


}
