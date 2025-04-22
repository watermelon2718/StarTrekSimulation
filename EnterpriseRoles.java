public enum EnterpriseRoles {
    CAPTAIN, CMDR, LT, DOCTOR, ENGINEER, COUNSELOR, ENSIGN; 

    private int rank;

    
    public int getRank(EnterpriseRoles role) {
        return rank;
    }

    public void assignRank() {
        EnterpriseRoles[] roles = {CAPTAIN, CMDR, LT, DOCTOR, ENGINEER, COUNSELOR, ENSIGN};
              
        for(int i = 0; i < roles.length; i++) {
            roles[i].rank = i;
        }

    }
}


