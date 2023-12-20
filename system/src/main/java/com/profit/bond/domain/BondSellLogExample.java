package com.profit.bond.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BondSellLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BondSellLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGpIdIsNull() {
            addCriterion("gp_id is null");
            return (Criteria) this;
        }

        public Criteria andGpIdIsNotNull() {
            addCriterion("gp_id is not null");
            return (Criteria) this;
        }

        public Criteria andGpIdEqualTo(String value) {
            addCriterion("gp_id =", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotEqualTo(String value) {
            addCriterion("gp_id <>", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdGreaterThan(String value) {
            addCriterion("gp_id >", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdGreaterThanOrEqualTo(String value) {
            addCriterion("gp_id >=", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdLessThan(String value) {
            addCriterion("gp_id <", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdLessThanOrEqualTo(String value) {
            addCriterion("gp_id <=", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdLike(String value) {
            addCriterion("gp_id like", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotLike(String value) {
            addCriterion("gp_id not like", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdIn(List<String> values) {
            addCriterion("gp_id in", values, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotIn(List<String> values) {
            addCriterion("gp_id not in", values, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdBetween(String value1, String value2) {
            addCriterion("gp_id between", value1, value2, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotBetween(String value1, String value2) {
            addCriterion("gp_id not between", value1, value2, "gpId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNull() {
            addCriterion("buy_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNotNull() {
            addCriterion("buy_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyIdEqualTo(Long value) {
            addCriterion("buy_id =", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotEqualTo(Long value) {
            addCriterion("buy_id <>", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThan(Long value) {
            addCriterion("buy_id >", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buy_id >=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThan(Long value) {
            addCriterion("buy_id <", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThanOrEqualTo(Long value) {
            addCriterion("buy_id <=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIn(List<Long> values) {
            addCriterion("buy_id in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotIn(List<Long> values) {
            addCriterion("buy_id not in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdBetween(Long value1, Long value2) {
            addCriterion("buy_id between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotBetween(Long value1, Long value2) {
            addCriterion("buy_id not between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("`count` is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("`count` is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("`count` =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("`count` <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("`count` >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("`count` >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("`count` <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("`count` <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("`count` in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("`count` not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("`count` between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("`count` not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Double value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Double value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Double value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Double value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Double value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Double value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Double> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Double> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Double value1, Double value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Double value1, Double value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNull() {
            addCriterion("total_cost is null");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNotNull() {
            addCriterion("total_cost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCostEqualTo(Double value) {
            addCriterion("total_cost =", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotEqualTo(Double value) {
            addCriterion("total_cost <>", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThan(Double value) {
            addCriterion("total_cost >", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThanOrEqualTo(Double value) {
            addCriterion("total_cost >=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThan(Double value) {
            addCriterion("total_cost <", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThanOrEqualTo(Double value) {
            addCriterion("total_cost <=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostIn(List<Double> values) {
            addCriterion("total_cost in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotIn(List<Double> values) {
            addCriterion("total_cost not in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostBetween(Double value1, Double value2) {
            addCriterion("total_cost between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotBetween(Double value1, Double value2) {
            addCriterion("total_cost not between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Double value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Double value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Double value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Double value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Double value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Double> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Double> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Double value1, Double value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Double value1, Double value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andSurplusCountIsNull() {
            addCriterion("surplus_count is null");
            return (Criteria) this;
        }

        public Criteria andSurplusCountIsNotNull() {
            addCriterion("surplus_count is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusCountEqualTo(Integer value) {
            addCriterion("surplus_count =", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountNotEqualTo(Integer value) {
            addCriterion("surplus_count <>", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountGreaterThan(Integer value) {
            addCriterion("surplus_count >", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplus_count >=", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountLessThan(Integer value) {
            addCriterion("surplus_count <", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountLessThanOrEqualTo(Integer value) {
            addCriterion("surplus_count <=", value, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountIn(List<Integer> values) {
            addCriterion("surplus_count in", values, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountNotIn(List<Integer> values) {
            addCriterion("surplus_count not in", values, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountBetween(Integer value1, Integer value2) {
            addCriterion("surplus_count between", value1, value2, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andSurplusCountNotBetween(Integer value1, Integer value2) {
            addCriterion("surplus_count not between", value1, value2, "surplusCount");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeIsNull() {
            addCriterion("realy_before is null");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeIsNotNull() {
            addCriterion("realy_before is not null");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeEqualTo(Double value) {
            addCriterion("realy_before =", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeNotEqualTo(Double value) {
            addCriterion("realy_before <>", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeGreaterThan(Double value) {
            addCriterion("realy_before >", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeGreaterThanOrEqualTo(Double value) {
            addCriterion("realy_before >=", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeLessThan(Double value) {
            addCriterion("realy_before <", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeLessThanOrEqualTo(Double value) {
            addCriterion("realy_before <=", value, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeIn(List<Double> values) {
            addCriterion("realy_before in", values, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeNotIn(List<Double> values) {
            addCriterion("realy_before not in", values, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeBetween(Double value1, Double value2) {
            addCriterion("realy_before between", value1, value2, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyBeforeNotBetween(Double value1, Double value2) {
            addCriterion("realy_before not between", value1, value2, "realyBefore");
            return (Criteria) this;
        }

        public Criteria andRealyAfterIsNull() {
            addCriterion("realy_after is null");
            return (Criteria) this;
        }

        public Criteria andRealyAfterIsNotNull() {
            addCriterion("realy_after is not null");
            return (Criteria) this;
        }

        public Criteria andRealyAfterEqualTo(Double value) {
            addCriterion("realy_after =", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterNotEqualTo(Double value) {
            addCriterion("realy_after <>", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterGreaterThan(Double value) {
            addCriterion("realy_after >", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterGreaterThanOrEqualTo(Double value) {
            addCriterion("realy_after >=", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterLessThan(Double value) {
            addCriterion("realy_after <", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterLessThanOrEqualTo(Double value) {
            addCriterion("realy_after <=", value, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterIn(List<Double> values) {
            addCriterion("realy_after in", values, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterNotIn(List<Double> values) {
            addCriterion("realy_after not in", values, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterBetween(Double value1, Double value2) {
            addCriterion("realy_after between", value1, value2, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andRealyAfterNotBetween(Double value1, Double value2) {
            addCriterion("realy_after not between", value1, value2, "realyAfter");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}