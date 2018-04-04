package com.example.c4q.capstone.userinterface.events.createevent;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.capstone.R;
import com.example.c4q.capstone.database.publicuserdata.PublicUser;
import com.example.c4q.capstone.database.publicuserdata.PublicUserDetails;
import com.example.c4q.capstone.userinterface.events.eventsrecyclerviews.InviteFriendsViewHolder;
import com.example.c4q.capstone.userinterface.user.userprofilefragments.userprofileviews.ContactListViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melg on 3/20/18.
 */

public class InviteListAdapter extends FirebaseRecyclerAdapter<PublicUserDetails, InviteFriendsViewHolder> {

    NewEventListener newEventListener;
    Context context;

    public InviteListAdapter(Class<PublicUserDetails> modelClass, int modelLayout, Class<InviteFriendsViewHolder> viewHolderClass, Query ref, NewEventListener newEventListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.newEventListener = newEventListener;
        this.context = context;
    }

    @Override
    protected void populateViewHolder(InviteFriendsViewHolder viewHolder, PublicUserDetails model, int position) {
        String first = model.getFirst_name();
        String last = model.getLast_name();
        String email = model.getEmail();
        String url = model.getIcon_url();

        viewHolder.setUserIcon(url);
        viewHolder.setName(first);
        viewHolder.setLastName(last);
        viewHolder.itemView.setTag(model.getUid());
        NewEventConverter eventConverter = new NewEventConverter();
        final PublicUser user = eventConverter.convertPubDetailsToPubUser(model);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView firstName = (TextView) v.findViewById(R.id.name_first);
                TextView lastName = (TextView) v.findViewById(R.id.name_last);
                ImageView checkImage = (ImageView) v.findViewById(R.id.friend_checked_image);
                if (checkImage.getTag().toString().equals("unChecked") ){
                    checkImage.setBackground(context.getResources().getDrawable(R.drawable.ic_check_circle_checked_24dp));
                    checkImage.setTag("checked");
                    firstName.setTextColor(context.getResources().getColor(R.color.colorAccent));
                    lastName.setTextColor(context.getResources().getColor(R.color.colorAccent));
                    newEventListener.friendInvited(user);
                } else{
                    firstName.setTextColor(context.getResources().getColor(R.color.colorAppGrey));
                    lastName.setTextColor(context.getResources().getColor(R.color.colorAppGrey));
                    checkImage.setBackground(context.getResources().getDrawable(R.drawable.ic_check_circle_unchecked_24dp));
                    checkImage.setTag("unChecked");
                    newEventListener.friendUnInvited(user);
                }
            }
        });
    }
}
