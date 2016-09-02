package sim.ssn.com.android_recyclerview_expandable.recyclerview.expand;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sim.ssn.com.android_recyclerview_expandable.R;

public class TestAdapter extends ExpandableRecyclerAdapter<TestAdapter.TestListItem> {

    protected static final int TYPE_HEADER = 1000;
    protected static final int TYPE_PERSON = 1001;

    public TestAdapter(Context context) {
        super(context);
        super.setItems(getSampleItems());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new HeaderViewHolder(inflate(R.layout.item_header, parent), R.id.expandable_cardview_item_header);
            case TYPE_PERSON:
            default:
                return new ChildViewHolder(inflate(R.layout.item_person, parent));
        }
    }

    @Override
    public void onBindViewHolder(ExpandableRecyclerAdapter.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((HeaderViewHolder) holder).bind(position);
                break;
            case TYPE_PERSON:
            default:
                ((ChildViewHolder) holder).bind(position);
                break;
        }
    }

    // ** LISTITEM ****************************************************************************** //
    public class TestListItem extends ExpandableRecyclerAdapter.ListItem {
        public String Text;

        public TestListItem(String group) {
            super(TYPE_HEADER);
            Text = group;
        }

        public TestListItem(String first, String last) {
            super(TYPE_PERSON);
            Text = first + " " + last;
        }
    }

    // ** HEADER ******************************************************************************** //
    public class HeaderViewHolder extends ExpandableRecyclerAdapter.HeaderViewHolder {
        TextView name;

        public HeaderViewHolder(View view) {
            super(view, (ImageView) view.findViewById(R.id.item_arrow));
            name = (TextView) view.findViewById(R.id.item_header_name);
        }

        public HeaderViewHolder(View view, int clickableViewID) {
            super(view, clickableViewID, (ImageView) view.findViewById(R.id.item_arrow));
            name = (TextView) view.findViewById(R.id.item_header_name);
        }

        public void bind(int position) {
            super.bind(position);
            name.setText(getVisibleItems().get(position).Text);
        }
    }

    // ** CHILD ********************************************************************************* //
    public class ChildViewHolder extends ExpandableRecyclerAdapter.ViewHolder {
        TextView name;
        View view;

        public ChildViewHolder(View view) {
            super(view);
            this.view = view;
            name = (TextView) view.findViewById(R.id.item_name);

        }

        public void bind(final int position) {
            name.setText(getVisibleItems().get(position).Text);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, getVisibleItems().get(position).Text, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // ** ITEMS ********************************************************************************* //
    private List<TestListItem> getSampleItems() {
        List<TestListItem> items = new ArrayList<>();

        items.add(new TestListItem("Friends"));
        items.add(new TestListItem("Bill", "Smith"));
        items.add(new TestListItem("John", "Doe"));
        items.add(new TestListItem("Frank", "Hall"));
        items.add(new TestListItem("Sue", "West"));
        items.add(new TestListItem("Family"));
        items.add(new TestListItem("Drew", "Smith"));
        items.add(new TestListItem("Chris", "Doe"));
        items.add(new TestListItem("Alex", "Hall"));
        items.add(new TestListItem("Associates"));
        items.add(new TestListItem("John", "Jones"));
        items.add(new TestListItem("Ed", "Smith"));
        items.add(new TestListItem("Jane", "Hall"));
        items.add(new TestListItem("Tim", "Lake"));
        items.add(new TestListItem("Colleagues"));
        items.add(new TestListItem("Carol", "Jones"));
        items.add(new TestListItem("Alex", "Smith"));
        items.add(new TestListItem("Kristin", "Hall"));
        items.add(new TestListItem("Pete", "Lake"));

        return items;
    }
}
