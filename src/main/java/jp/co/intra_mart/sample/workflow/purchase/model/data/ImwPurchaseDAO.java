package jp.co.intra_mart.sample.workflow.purchase.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.intra_mart.framework.base.data.DataAccessException;
import jp.co.intra_mart.framework.base.data.DataConnectException;
import jp.co.intra_mart.framework.base.data.DataPropertyException;
import jp.co.intra_mart.framework.base.data.TenantDBDAO;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

public class ImwPurchaseDAO extends TenantDBDAO implements ImwPurchaseDAOIF {

    /* 取得 */
    private static final String SQL_SELECT = "SELECT user_data_id,system_matter_id,"
            + "item_name,item_amount,item_price,"
            + "item_total,item_comment,"
            + "end_flag,archive_flag "
            + "FROM sample_imw_t_purchase "
            + "WHERE user_data_id=?";
    /* 登録 */
    private static final String SQL_INSERT = "INSERT INTO sample_imw_t_purchase ("
            + "user_data_id,system_matter_id,"
            + "item_name,item_amount,item_price,"
            + "item_total,item_comment,"
            + "end_flag,archive_flag"
            + ") VALUES (?,?,?,?,?,?,?,?,?)";
    /* 更新 */
    private static final String SQL_UPDATE = "UPDATE sample_imw_t_purchase SET "
            + "system_matter_id=?,item_name=?,"
            + "item_amount=?,item_price=?,"
            + "item_total=?,item_comment=?,"
            + "end_flag=?,archive_flag=? "
            + "WHERE user_data_id=?";
    /* 削除 */
    private static final String SQL_DELETE = "DELETE FROM sample_imw_t_purchase WHERE user_data_id=?";

    /**
     *    主キーからImwTPurchaseModelObjectを作成します。<BR><BR>
     *
     *    @param  userDataId sample_imw_t_purchase テーブルの主キー
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @return ImwTPurchaseModelObjectのインスタンス
     */
    @Override
    public ImwPurchaseModelObject select(final String userDataId)
            throws DataConnectException, DataAccessException, DataPropertyException {
        Connection con         = null;
        PreparedStatement stmt = null;
        ResultSet result       = null;
        ImwPurchaseModelObject modelObject = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            stmt.setString(1, userDataId);
            result = stmt.executeQuery();
            if (result.next()) {
                modelObject = new ImwPurchaseModelObject();
                modelObject.setUserDataId(result.getString("user_data_id"));
                modelObject.setSystemMtterId(result.getString("system_matter_id"));
                modelObject.setItemName(result.getString("item_name"));
                modelObject.setItemAmount(result.getString("item_amount"));
                modelObject.setItemPrice(result.getString("item_price"));
                modelObject.setItemTotal(result.getString("item_total"));
                modelObject.setItemComment(result.getString("item_comment"));
                modelObject.setEndFlag(result.getString("end_flag"));
                modelObject.setArchiveFlag(result.getString("archive_flag"));
            }
        } catch (final SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modelObject;
    }

    /**
     *    ImwTPurchaseModelObjectを引数にもらってINSERT処理を行います。<BR><BR>
     *
     *    @param  modelObject INSERTしたいImwTPurchaseModelObject
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    @Override
    public void insert(final ImwPurchaseModelObject modelObject)
            throws DataConnectException, DataAccessException, DataPropertyException {
        Connection con         = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, modelObject.getUserDataId());
            stmt.setString(2, modelObject.getSystemMtterId());
            stmt.setString(3, modelObject.getItemName());
            stmt.setString(4, modelObject.getItemAmount());
            stmt.setString(5, modelObject.getItemPrice());
            stmt.setString(6, modelObject.getItemTotal());
            stmt.setString(7, modelObject.getItemComment());
            stmt.setString(8, modelObject.getEndFlag());
            stmt.setString(9, modelObject.getArchiveFlag());
            stmt.executeUpdate();
        } catch (final SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *    ImwTPurchaseModelObjectを引数にもらってUPDATE処理を行います。<BR><BR>
     *
     *    @param  modelObject UPDATEしたいImwTPurchaseModelObject
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    @Override
    public void update(final ImwPurchaseModelObject modelObject)
            throws DataConnectException, DataAccessException, DataPropertyException {
        Connection con         = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modelObject.getSystemMtterId());
            stmt.setString(2, modelObject.getItemName());
            stmt.setString(3, modelObject.getItemAmount());
            stmt.setString(4, modelObject.getItemPrice());
            stmt.setString(5, modelObject.getItemTotal());
            stmt.setString(6, modelObject.getItemComment());
            stmt.setString(7, modelObject.getEndFlag());
            stmt.setString(8, modelObject.getArchiveFlag());
            stmt.setString(9, modelObject.getUserDataId());
            stmt.executeUpdate();
        } catch (final SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *    主キーを引数にもらってDELETE処理を行います。<BR><BR>
     *
     *    @param  userDataId sample_imw_t_purchase テーブルの主キー
     *    @throws DataConnectException データ接続に関連する例外が発生
     *    @throws DataAccessException データアクセス時の例外が発生
     *    @throws DataPropertyException データプロパティ取得時の例外が発生
     */
    @Override
    public void delete(final String userDataId)
            throws DataConnectException, DataAccessException, DataPropertyException {
        Connection con         = null;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setString(1, userDataId);
            stmt.executeUpdate();
        } catch (final SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
