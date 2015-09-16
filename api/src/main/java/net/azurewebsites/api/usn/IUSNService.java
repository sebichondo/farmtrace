package net.azurewebsites.api.usn;

import com.squareup.otto.Bus;

import java.util.Date;

/**
 * Created by sebichondo on 9/12/15.
 */
public interface IUSNService {
    public void getUSNs(Bus bus);

    public void saveUSNs(Long usnID, Date usnDate, Long usnUserID, Long appUSNID, Bus bus);
}
