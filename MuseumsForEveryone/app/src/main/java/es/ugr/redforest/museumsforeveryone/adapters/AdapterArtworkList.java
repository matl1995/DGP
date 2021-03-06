package es.ugr.redforest.museumsforeveryone.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.ugr.redforest.museumsforeveryone.R;
import es.ugr.redforest.museumsforeveryone.models.Content;
import es.ugr.redforest.museumsforeveryone.models.ContentInformation;
import es.ugr.redforest.museumsforeveryone.models.Multimedia;
import es.ugr.redforest.museumsforeveryone.utils.QueryBBDD;

/**
 * Adapter used in RecyclerView to display a list of Content information
 *
 * @author Miguel Ángel Torres López
 * @author Emilio Chica Jiménez
 * @version 1.0.0
 * @see ContentInformation
 * @see RecyclerView
 */

public class AdapterArtworkList extends RecyclerView.Adapter<AdapterArtworkList.ContentInformationViewHolder> {
    private ArrayList<ContentInformation> contentInformationList;   // ArrayList containing the Content Types to show
    private ArrayList<Content> contents; //ArrayList contents with images to show
    private Context context; //App's context

    /**
     * ViewHolder needed to handle how to show elements
     *
     * @author Emilio Chica Jiménez
     * @version 1.0.0
     * @see "layout/content_information_list_row.xml"
     */
    public static class ContentInformationViewHolder extends RecyclerView.ViewHolder {
        private TextView contentInformationTxt;
        private ImageView contentInformationImage;

        /**
         * Constructor method. Gets references to visible elements
         *
         * @param view Needed by the superclass constructor
         */
        public  ContentInformationViewHolder(View view) {
            super(view);
            contentInformationImage = (ImageView) view.findViewById(R.id.rowIcon);
            contentInformationTxt = (TextView) view.findViewById(R.id.content_information_txt);
        }
    }

    /**
     * Constructor method.
     *
     * @param contentInformationList List of languages to show
     * @param contents ArrayList contents with images to show
     * @param context App's context
     */
    public AdapterArtworkList(ArrayList<ContentInformation> contentInformationList, ArrayList<Content> contents, Context context) {
        this.contentInformationList = contentInformationList;
        this.contents = contents;
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContentInformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_information_list_row, parent, false);
        return new ContentInformationViewHolder(itemView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(ContentInformationViewHolder holder, int position) {
        ContentInformation contentType = contentInformationList.get(position);
        holder.contentInformationTxt.setText(contentType.getName());
        final ArrayList<Multimedia> imageMultimedia = contents.get(position).getMultimediaByType("image");
        if(imageMultimedia.size()>0) {
            if (imageMultimedia.get(0).getUrl() != null)
                Picasso.with(context).load(QueryBBDD.server + imageMultimedia.get(0).getUrl()).into(holder.contentInformationImage);
            if (imageMultimedia.get(0).getAlternativeText() != null)
                holder.contentInformationImage.setContentDescription(imageMultimedia.get(0).getAlternativeText());
        }



    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return contentInformationList.size();
    }


}
