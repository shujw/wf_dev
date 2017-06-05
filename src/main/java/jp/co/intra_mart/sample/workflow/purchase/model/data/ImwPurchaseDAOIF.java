package jp.co.intra_mart.sample.workflow.purchase.model.data;

import jp.co.intra_mart.framework.base.data.DataAccessException;
import jp.co.intra_mart.framework.base.data.DataConnectException;
import jp.co.intra_mart.framework.base.data.DataPropertyException;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

public interface ImwPurchaseDAOIF {
    /**
     *    主キーからImwTPurchaseModelObjectを作成します。<BR><BR>
     *
     *    @param  userDataId sample_imw_t_purchase テーブルの主キー 
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     *    @return PurchaseModelObjectのインスタンス
     */
    public ImwPurchaseModelObject select(String userDataId)
        throws DataConnectException, DataAccessException, DataPropertyException;

    /**
     *    ImwTPurchaseModelObjectを引数にもらってINSERT処理を行います。<BR><BR>
     *
     *    @param  modelObject InsertしたいImwTPurchaseModelObject
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    public void insert(ImwPurchaseModelObject modelObject)
        throws DataConnectException, DataAccessException, DataPropertyException;

    /**
     *    ImwTPurchaseModelObjectを引数にもらってUPDATE処理を行います。<BR><BR>
     *
     *    @param  modelObject UpdateしたいImwTPurchaseModelObject
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    public void update(ImwPurchaseModelObject modelObject)
        throws DataConnectException, DataAccessException, DataPropertyException;

    /**
     *    主キーを引数にもらってDELETE処理を行います。<BR><BR>
     *
     *    @param  userDataId sample_imw_t_purchase テーブルの主キー
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    public void delete(String userDataId)
        throws DataConnectException, DataAccessException, DataPropertyException;

}
