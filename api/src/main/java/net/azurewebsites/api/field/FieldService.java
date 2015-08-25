package net.azurewebsites.api.field;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sebichondo on 8/19/15.
 */
public class FieldService implements IFieldService {
    private IApiService apiService;

    @Inject
    public FieldService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getFields(Bus bus) {
        apiService.getFields(new RestCallback<List<FieldResponse>>(bus) {
        });
    }
}
