package com.example.c4q.capstone.userinterface.events.createevent;

import com.example.c4q.capstone.database.events.EventGuest;
import com.example.c4q.capstone.database.events.Events;
import com.example.c4q.capstone.database.events.Venue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by amirahoxendine on 3/29/18.
 */

public class VenueVoteUtility {
    public Events event;
    public boolean vote_complete;
    public Venue topVenue;
    public HashMap<Venue, Integer> venueVoteMap;
    int yayCount;

    public VenueVoteUtility(Events event){
        this.event = event;
        vote_complete = checkVoteComplete();
        venueVoteMap = countAllVenueVotes();
        topVenue = hightestVotedVenue();

    }
    public boolean checkVoteComplete(){
        List<EventGuest> guestList = new ArrayList<>();
        guestList.addAll(event.getEvent_guest_map().values());
        for (EventGuest guest: guestList){
            if (!guest.hasVoted()){
                return false;
            }
        }
        return true;
    }

    public int countVenueVote(Venue venue){
        yayCount = 0;
        for(String user: venue.getVenue_vote().keySet()){
            if (venue.getVenue_vote().get(user)){
                yayCount++;
            }
        }
        //calculate votes
        return yayCount;
    }

    public HashMap<Venue, Integer> countAllVenueVotes(){
        for (Venue venue: event.getVenue_map().values()){
            int yayVotes = countVenueVote(venue);
            venueVoteMap.put(venue, yayVotes);
        }
        return venueVoteMap;
    }

    public Venue hightestVotedVenue(){
        Venue venue = new Venue();

        return venue;
    }
}
