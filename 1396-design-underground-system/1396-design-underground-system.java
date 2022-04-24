class UndergroundSystem {
    
    HashMap<Integer, Person> map;//id, person
    HashMap<String, HashMap<String, Track>> station;// startStation, track

    public UndergroundSystem() {
        station = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Person(stationName, t));
        if(!station.containsKey(stationName)){
            station.put(stationName, new HashMap<>());
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        Person in = map.get(id);
        int tdiff = t-in.time;
        
        if(!station.get(in.sn).containsKey(stationName)){
            station.get(in.sn).put(stationName, new Track());
        }
        
        Track track = station.get(in.sn).get(stationName);
        double average = (track.avg*track.count + tdiff)/(track.count+1);
        track.count += 1;
        track.avg = average;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return station.get(startStation).get(endStation).avg;
    }
}

class Person {
    String sn;
    int time;
    
    public Person(String s, int t){
        this.sn = s;
        this.time = t;
    }
}

class Track {
    double avg;
    int count;
    
    public Track() {
        avg = 0;
        count = 0;
    }
    
    public Track(double avg, int count) {
        this.avg = avg;
        this.count = count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */