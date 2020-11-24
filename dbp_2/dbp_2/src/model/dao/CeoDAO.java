package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ceo;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ���� USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ����
 */
public class CeoDAO {
	private JDBCUtil jdbcUtil = null;

	public CeoDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil ��ü ����
	}

	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
	 */
	public int create(Ceo ceo) throws SQLException {
		String sql = "INSERT INTO CEO (CEOID, CEONAME, CEOPHONE, REGISTRATIONNUM, CEOPASSWD) "
				+ "VALUES (?, ?, ?, ?, ?)";
		Object[] param = new Object[] { ceo.getCeoId(), ceo.getName(), ceo.getPhone(), ceo.getCeoNum(),
				ceo.getPassword() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil �� insert���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ������ ����� ������ ����.
	 */
	public int update(Ceo ceo) throws SQLException {
		String sql = "UPDATE CEO " + "SET CEONAME=?, CEOPHONE=?, REGISTRATIONNUM=?, CEOPASSWD=? " + "WHERE CEOID=?";
		Object[] param = new Object[] { ceo.getName(), ceo.getPhone(), ceo.getCeoNum(), ceo.getPassword(),
				ceo.getCeoId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil�� update���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String ceoId) throws SQLException {
		String sql = "DELETE FROM CEO WHERE CEOID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ceoId }); // JDBCUtil�� delete���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ �����Ͽ� ��ȯ.
	 */
	public Ceo findUser(String ceoId) throws SQLException {
		String sql = "SELECT CEONAME, CEOPHONE, REGISTRATIONNUM, CEOPASSWD " + "FROM CEO " + "WHERE CEOID=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ceoId }); // JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			if (rs.next()) { // �л� ���� �߰�
				Ceo ceo = new Ceo( // User ��ü�� �����Ͽ� �л� ������ ����
						ceoId, rs.getString("CEONAME"), rs.getString("CEOPHONE"), rs.getString("REGISTRATIONNUM"),
						rs.getString("CEOPASSWD"));
				return ceo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Ceo> findUserList() throws SQLException {
		String sql = "SELECT CEOID, CEONAME, CEOPHONE, REGISTRATIONNUM, CEOPASSWD " + "FROM CEO " + "ORDER BY CEOID";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			List<Ceo> ceoList = new ArrayList<Ceo>(); // User���� ����Ʈ ����
			while (rs.next()) {
				Ceo ceo = new Ceo( // User ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getString("CEOID"), rs.getString("CEONAME"), rs.getString("CEOPHONE"),
						rs.getString("REGISTRATIONNUM"), rs.getString("CEOPASSWD"));
				ceoList.add(ceo); // List�� User ��ü ����
			}
			return ceoList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ� �ش��ϴ� ����� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<Ceo> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT CEOID, CEONAME, CEOPHONE, REGISTRATIONNUM, CEOPASSWD " + "FROM CEO " + "ORDER BY CEOID";
		jdbcUtil.setSqlAndParameters(sql, null, // JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE, // cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			int start = ((currentPage - 1) * countPerPage) + 1; // ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) { // Ŀ���� ���� ������ �̵�
				List<Ceo> ceoList = new ArrayList<Ceo>(); // User���� ����Ʈ ����
				do {
					Ceo ceo = new Ceo( // User ��ü�� �����Ͽ� ���� ���� ������ ����
							rs.getString("CEOID"), rs.getString("CEONAME"), rs.getString("CEOPHONE"),
							rs.getString("REGISTRATIONNUM"), rs.getString("CEOPASSWD"));
					ceoList.add(ceo); // ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));
				return ceoList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����ڰ� �����ϴ��� �˻�
	 */
	public boolean existingUser(String ceoId) throws SQLException {
		String sql = "SELECT count(*) FROM CEO WHERE CEOID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { ceoId }); // JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return false;
	}
}
