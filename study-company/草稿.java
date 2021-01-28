   if (age <= 100) {
                    IpRiskFactorSex riskFactorSex = universeAttach.getRiskFactorSex(age - 1);
                    factor = riskFactorSex.getRate();
                } else {
                    IpRiskFactorSex riskFactorSex = universeAttach.getRiskFactorSex(100);
                    factor = riskFactorSex.getRate();
                }