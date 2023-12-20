package com.profit.bond.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BondStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BondStatisticsExample() {
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Double value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Double value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Double value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Double value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Double value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Double value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Double> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Double> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Double value1, Double value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Double value1, Double value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andReadyIsNull() {
            addCriterion("ready is null");
            return (Criteria) this;
        }

        public Criteria andReadyIsNotNull() {
            addCriterion("ready is not null");
            return (Criteria) this;
        }

        public Criteria andReadyEqualTo(Double value) {
            addCriterion("ready =", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotEqualTo(Double value) {
            addCriterion("ready <>", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyGreaterThan(Double value) {
            addCriterion("ready >", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyGreaterThanOrEqualTo(Double value) {
            addCriterion("ready >=", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyLessThan(Double value) {
            addCriterion("ready <", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyLessThanOrEqualTo(Double value) {
            addCriterion("ready <=", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyIn(List<Double> values) {
            addCriterion("ready in", values, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotIn(List<Double> values) {
            addCriterion("ready not in", values, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyBetween(Double value1, Double value2) {
            addCriterion("ready between", value1, value2, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotBetween(Double value1, Double value2) {
            addCriterion("ready not between", value1, value2, "ready");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("`position` is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("`position` is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(Double value) {
            addCriterion("`position` =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(Double value) {
            addCriterion("`position` <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(Double value) {
            addCriterion("`position` >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Double value) {
            addCriterion("`position` >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(Double value) {
            addCriterion("`position` <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(Double value) {
            addCriterion("`position` <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<Double> values) {
            addCriterion("`position` in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<Double> values) {
            addCriterion("`position` not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(Double value1, Double value2) {
            addCriterion("`position` between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(Double value1, Double value2) {
            addCriterion("`position` not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andProfitNumberIsNull() {
            addCriterion("profit_number is null");
            return (Criteria) this;
        }

        public Criteria andProfitNumberIsNotNull() {
            addCriterion("profit_number is not null");
            return (Criteria) this;
        }

        public Criteria andProfitNumberEqualTo(Integer value) {
            addCriterion("profit_number =", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberNotEqualTo(Integer value) {
            addCriterion("profit_number <>", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberGreaterThan(Integer value) {
            addCriterion("profit_number >", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("profit_number >=", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberLessThan(Integer value) {
            addCriterion("profit_number <", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("profit_number <=", value, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberIn(List<Integer> values) {
            addCriterion("profit_number in", values, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberNotIn(List<Integer> values) {
            addCriterion("profit_number not in", values, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberBetween(Integer value1, Integer value2) {
            addCriterion("profit_number between", value1, value2, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andProfitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("profit_number not between", value1, value2, "profitNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberIsNull() {
            addCriterion("loss_number is null");
            return (Criteria) this;
        }

        public Criteria andLossNumberIsNotNull() {
            addCriterion("loss_number is not null");
            return (Criteria) this;
        }

        public Criteria andLossNumberEqualTo(Integer value) {
            addCriterion("loss_number =", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberNotEqualTo(Integer value) {
            addCriterion("loss_number <>", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberGreaterThan(Integer value) {
            addCriterion("loss_number >", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("loss_number >=", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberLessThan(Integer value) {
            addCriterion("loss_number <", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberLessThanOrEqualTo(Integer value) {
            addCriterion("loss_number <=", value, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberIn(List<Integer> values) {
            addCriterion("loss_number in", values, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberNotIn(List<Integer> values) {
            addCriterion("loss_number not in", values, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberBetween(Integer value1, Integer value2) {
            addCriterion("loss_number between", value1, value2, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andLossNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("loss_number not between", value1, value2, "lossNumber");
            return (Criteria) this;
        }

        public Criteria andWinningIsNull() {
            addCriterion("winning is null");
            return (Criteria) this;
        }

        public Criteria andWinningIsNotNull() {
            addCriterion("winning is not null");
            return (Criteria) this;
        }

        public Criteria andWinningEqualTo(String value) {
            addCriterion("winning =", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotEqualTo(String value) {
            addCriterion("winning <>", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningGreaterThan(String value) {
            addCriterion("winning >", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningGreaterThanOrEqualTo(String value) {
            addCriterion("winning >=", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningLessThan(String value) {
            addCriterion("winning <", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningLessThanOrEqualTo(String value) {
            addCriterion("winning <=", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningLike(String value) {
            addCriterion("winning like", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotLike(String value) {
            addCriterion("winning not like", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningIn(List<String> values) {
            addCriterion("winning in", values, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotIn(List<String> values) {
            addCriterion("winning not in", values, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningBetween(String value1, String value2) {
            addCriterion("winning between", value1, value2, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotBetween(String value1, String value2) {
            addCriterion("winning not between", value1, value2, "winning");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(Double value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(Double value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(Double value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(Double value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(Double value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(Double value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<Double> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<Double> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(Double value1, Double value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(Double value1, Double value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIsNull() {
            addCriterion("buy_money is null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIsNotNull() {
            addCriterion("buy_money is not null");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyEqualTo(Double value) {
            addCriterion("buy_money =", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotEqualTo(Double value) {
            addCriterion("buy_money <>", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThan(Double value) {
            addCriterion("buy_money >", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("buy_money >=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThan(Double value) {
            addCriterion("buy_money <", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyLessThanOrEqualTo(Double value) {
            addCriterion("buy_money <=", value, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyIn(List<Double> values) {
            addCriterion("buy_money in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotIn(List<Double> values) {
            addCriterion("buy_money not in", values, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyBetween(Double value1, Double value2) {
            addCriterion("buy_money between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andBuyMoneyNotBetween(Double value1, Double value2) {
            addCriterion("buy_money not between", value1, value2, "buyMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIsNull() {
            addCriterion("sell_money is null");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIsNotNull() {
            addCriterion("sell_money is not null");
            return (Criteria) this;
        }

        public Criteria andSellMoneyEqualTo(Double value) {
            addCriterion("sell_money =", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotEqualTo(Double value) {
            addCriterion("sell_money <>", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyGreaterThan(Double value) {
            addCriterion("sell_money >", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_money >=", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyLessThan(Double value) {
            addCriterion("sell_money <", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyLessThanOrEqualTo(Double value) {
            addCriterion("sell_money <=", value, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyIn(List<Double> values) {
            addCriterion("sell_money in", values, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotIn(List<Double> values) {
            addCriterion("sell_money not in", values, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyBetween(Double value1, Double value2) {
            addCriterion("sell_money between", value1, value2, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andSellMoneyNotBetween(Double value1, Double value2) {
            addCriterion("sell_money not between", value1, value2, "sellMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyIsNull() {
            addCriterion("loss_money is null");
            return (Criteria) this;
        }

        public Criteria andLossMoneyIsNotNull() {
            addCriterion("loss_money is not null");
            return (Criteria) this;
        }

        public Criteria andLossMoneyEqualTo(Double value) {
            addCriterion("loss_money =", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyNotEqualTo(Double value) {
            addCriterion("loss_money <>", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyGreaterThan(Double value) {
            addCriterion("loss_money >", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("loss_money >=", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyLessThan(Double value) {
            addCriterion("loss_money <", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyLessThanOrEqualTo(Double value) {
            addCriterion("loss_money <=", value, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyIn(List<Double> values) {
            addCriterion("loss_money in", values, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyNotIn(List<Double> values) {
            addCriterion("loss_money not in", values, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyBetween(Double value1, Double value2) {
            addCriterion("loss_money between", value1, value2, "lossMoney");
            return (Criteria) this;
        }

        public Criteria andLossMoneyNotBetween(Double value1, Double value2) {
            addCriterion("loss_money not between", value1, value2, "lossMoney");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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