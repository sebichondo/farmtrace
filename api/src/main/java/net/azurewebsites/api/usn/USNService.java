package net.azurewebsites.api.usn;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.Date;
import java.util.List;

/**
 * Created by sebichondo on 9/12/15.
 */
public class USNService implements IUSNService {
    private IApiService apiService;

    public USNService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getUSNs(Bus bus) {
        apiService.getUpdateSequenceNumbers(new RestCallback<List<USNResponse>>(bus) {
        });
    }

    @Override
    public void saveUSNs(Long usnID, Date usnDate, Long usnUserID, Long appUSNID, Bus bus) {

        apiService.saveUpdateSequenceNumbers(new USN(usnID, usnDate, usnUserID, appUSNID), new RestCallback<USNResponse>(bus) {
        });
    }
}