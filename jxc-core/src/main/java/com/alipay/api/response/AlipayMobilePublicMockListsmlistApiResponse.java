package com.alipay.api.response;

import java.util.List;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;
import com.alipay.api.domain.ListListSmMockModel;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.mobile.public.mock.listsmlist.api response.
 *
 * @author auto create
 * @since 1.0, 2016-03-30 19:35:58
 */
public class AlipayMobilePublicMockListsmlistApiResponse extends AlipayResponse {

    private static final long serialVersionUID = 4128949612346561589L;

    /**
     * 简单模型嵌套list
     */
    @ApiListField("list_sm_model_list")
    @ApiField("list_list_sm_mock_model")
    private List<ListListSmMockModel> listSmModelList;

    public void setListSmModelList(List<ListListSmMockModel> listSmModelList) {
        this.listSmModelList = listSmModelList;
    }

    public List<ListListSmMockModel> getListSmModelList() {
        return this.listSmModelList;
    }

}
