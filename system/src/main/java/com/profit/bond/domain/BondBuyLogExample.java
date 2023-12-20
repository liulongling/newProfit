package com.profit.bond.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BondBuyLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BondBuyLogExample() {
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

        public Criteria andBackMoneyIsNull() {
            addCriterion("back_money is null");
            return (Criteria) this;
        }

        public Criteria andBackMoneyIsNotNull() {
            addCriterion("back_money is not null");
            return (Criteria) this;
        }

        public Criteria andBackMoneyEqualTo(Double value) {
            addCriterion("back_money =", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyNotEqualTo(Double value) {
            addCriterion("back_money <>", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyGreaterThan(Double value) {
            addCriterion("back_money >", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("back_money >=", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyLessThan(Double value) {
            addCriterion("back_money <", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyLessThanOrEqualTo(Double value) {
            addCriterion("back_money <=", value, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyIn(List<Double> values) {
            addCriterion("back_money in", values, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyNotIn(List<Double> values) {
            addCriterion("back_money not in", values, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyBetween(Double value1, Double value2) {
            addCriterion("back_money between", value1, value2, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackMoneyNotBetween(Double value1, Double value2) {
            addCriterion("back_money not between", value1, value2, "backMoney");
            return (Criteria) this;
        }

        public Criteria andBackTimeIsNull() {
            addCriterion("back_time is null");
            return (Criteria) this;
        }

        public Criteria andBackTimeIsNotNull() {
            addCriterion("back_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackTimeEqualTo(Date value) {
            addCriterion("back_time =", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeNotEqualTo(Date value) {
            addCriterion("back_time <>", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeGreaterThan(Date value) {
            addCriterion("back_time >", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("back_time >=", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeLessThan(Date value) {
            addCriterion("back_time <", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeLessThanOrEqualTo(Date value) {
            addCriterion("back_time <=", value, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeIn(List<Date> values) {
            addCriterion("back_time in", values, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeNotIn(List<Date> values) {
            addCriterion("back_time not in", values, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeBetween(Date value1, Date value2) {
            addCriterion("back_time between", value1, value2, "backTime");
            return (Criteria) this;
        }

        public Criteria andBackTimeNotBetween(Date value1, Date value2) {
            addCriterion("back_time not between", value1, value2, "backTime");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(Double value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(Double value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(Double value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(Double value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(Double value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(Double value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<Double> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<Double> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(Double value1, Double value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(Double value1, Double value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andBuyCostIsNull() {
            addCriterion("buy_cost is null");
            return (Criteria) this;
        }

        public Criteria andBuyCostIsNotNull() {
            addCriterion("buy_cost is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCostEqualTo(Double value) {
            addCriterion("buy_cost =", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotEqualTo(Double value) {
            addCriterion("buy_cost <>", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostGreaterThan(Double value) {
            addCriterion("buy_cost >", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostGreaterThanOrEqualTo(Double value) {
            addCriterion("buy_cost >=", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostLessThan(Double value) {
            addCriterion("buy_cost <", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostLessThanOrEqualTo(Double value) {
            addCriterion("buy_cost <=", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostIn(List<Double> values) {
            addCriterion("buy_cost in", values, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotIn(List<Double> values) {
            addCriterion("buy_cost not in", values, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostBetween(Double value1, Double value2) {
            addCriterion("buy_cost between", value1, value2, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotBetween(Double value1, Double value2) {
            addCriterion("buy_cost not between", value1, value2, "buyCost");
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

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSellCountIsNull() {
            addCriterion("sell_count is null");
            return (Criteria) this;
        }

        public Criteria andSellCountIsNotNull() {
            addCriterion("sell_count is not null");
            return (Criteria) this;
        }

        public Criteria andSellCountEqualTo(Integer value) {
            addCriterion("sell_count =", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotEqualTo(Integer value) {
            addCriterion("sell_count <>", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountGreaterThan(Integer value) {
            addCriterion("sell_count >", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_count >=", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountLessThan(Integer value) {
            addCriterion("sell_count <", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountLessThanOrEqualTo(Integer value) {
            addCriterion("sell_count <=", value, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountIn(List<Integer> values) {
            addCriterion("sell_count in", values, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotIn(List<Integer> values) {
            addCriterion("sell_count not in", values, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountBetween(Integer value1, Integer value2) {
            addCriterion("sell_count between", value1, value2, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_count not between", value1, value2, "sellCount");
            return (Criteria) this;
        }

        public Criteria andSellIncomeIsNull() {
            addCriterion("sell_income is null");
            return (Criteria) this;
        }

        public Criteria andSellIncomeIsNotNull() {
            addCriterion("sell_income is not null");
            return (Criteria) this;
        }

        public Criteria andSellIncomeEqualTo(Double value) {
            addCriterion("sell_income =", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeNotEqualTo(Double value) {
            addCriterion("sell_income <>", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeGreaterThan(Double value) {
            addCriterion("sell_income >", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_income >=", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeLessThan(Double value) {
            addCriterion("sell_income <", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeLessThanOrEqualTo(Double value) {
            addCriterion("sell_income <=", value, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeIn(List<Double> values) {
            addCriterion("sell_income in", values, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeNotIn(List<Double> values) {
            addCriterion("sell_income not in", values, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeBetween(Double value1, Double value2) {
            addCriterion("sell_income between", value1, value2, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andSellIncomeNotBetween(Double value1, Double value2) {
            addCriterion("sell_income not between", value1, value2, "sellIncome");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDateEqualTo(String value) {
            addCriterion("buy_date =", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotEqualTo(String value) {
            addCriterion("buy_date <>", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThan(String value) {
            addCriterion("buy_date >", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThanOrEqualTo(String value) {
            addCriterion("buy_date >=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThan(String value) {
            addCriterion("buy_date <", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThanOrEqualTo(String value) {
            addCriterion("buy_date <=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLike(String value) {
            addCriterion("buy_date like", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotLike(String value) {
            addCriterion("buy_date not like", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateIn(List<String> values) {
            addCriterion("buy_date in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotIn(List<String> values) {
            addCriterion("buy_date not in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateBetween(String value1, String value2) {
            addCriterion("buy_date between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotBetween(String value1, String value2) {
            addCriterion("buy_date not between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andFinancingIsNull() {
            addCriterion("financing is null");
            return (Criteria) this;
        }

        public Criteria andFinancingIsNotNull() {
            addCriterion("financing is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingEqualTo(Byte value) {
            addCriterion("financing =", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingNotEqualTo(Byte value) {
            addCriterion("financing <>", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingGreaterThan(Byte value) {
            addCriterion("financing >", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingGreaterThanOrEqualTo(Byte value) {
            addCriterion("financing >=", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingLessThan(Byte value) {
            addCriterion("financing <", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingLessThanOrEqualTo(Byte value) {
            addCriterion("financing <=", value, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingIn(List<Byte> values) {
            addCriterion("financing in", values, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingNotIn(List<Byte> values) {
            addCriterion("financing not in", values, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingBetween(Byte value1, Byte value2) {
            addCriterion("financing between", value1, value2, "financing");
            return (Criteria) this;
        }

        public Criteria andFinancingNotBetween(Byte value1, Byte value2) {
            addCriterion("financing not between", value1, value2, "financing");
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