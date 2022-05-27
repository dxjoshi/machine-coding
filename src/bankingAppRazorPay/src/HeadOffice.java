package bankingAppRazorPay.src;

import java.util.ArrayList;
import java.util.List;

public class HeadOffice {

    private List<Branch> branches;
    Integer id;
	
	public HeadOffice() {
        this.branches = new ArrayList<>();
        this.id = 1;
	}
	
	public Branch createBranch() {
        Branch branch = new Branch(String.valueOf(id));
        branches.add(branch);
        id += 1;
        return branch;
	}
	
	public Branch getBranchById(String id) throws Exception {
        Branch res = null;
        for(Branch branch : branches) {
            if (branch.getId().equals(id)) {
                res = branch;
            }
        }
        // if (res == null) throw new Exception();
        return res;
	}
	
	public List<Branch> getAllBranches() {
		return this.branches;
	}
	
}
