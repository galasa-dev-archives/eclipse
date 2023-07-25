/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.runs;

import java.time.Instant;

import dev.galasa.eclipse.ui.PropertyUpdate.Type;

public class Run {

	private final String runName;

	private String       status;
	private String       test;
	private String       result;
	private String       requestor;
	private String       currentTestMethod;
	private int          totalTestMethods = -1;
	private int          actualTestMethod = -1;

	private Instant      lastPropertyModification = Instant.now();

	private Instant      queued                   = Instant.ofEpochSecond(0);

	public Run(String runName) {
		this.runName = runName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(runName);
		sb.append(" - ");
		if (status != null) {
			sb.append(status);
		} else {
			sb.append("unknown");
		}
		sb.append(" - ");
		sb.append(this.test);

		if (this.result != null) {
			sb.append(" - ");
			sb.append(this.result);
		}

		if (this.currentTestMethod != null) {
			sb.append(" - ");
			sb.append(this.currentTestMethod);
			sb.append("(");
			sb.append(Integer.toString(this.actualTestMethod));
			sb.append(" of ");
			sb.append(Integer.toString(this.totalTestMethods));
			sb.append(")");
		}
		
		if (this.requestor != null) {
			sb.append(" - ");
			sb.append(this.requestor);
		}
		return sb.toString();
	}

	public synchronized void propertyUpdate(String key, String value, Type type) {
		if (type == Type.DELETE) {
			value = null;
		}

		switch (key) {
		case "status":
			this.status = value;
			break;
		case "result":
			this.result = value;
			break;
		case "requestor":
			this.requestor = value;
			break;
		case "queued":
			if (value == null) {
				this.queued = Instant.ofEpochSecond(0);
			} else {
				try {
					this.queued = Instant.parse(value);
				} catch (Throwable e) {
					this.queued = Instant.ofEpochSecond(0);
				}
			}
			break;
		case "test":
			if (value == null) {
				this.test = "?";
			} else {
				String[] testParts = value.split("[/\\.]");
				if (testParts.length < 1) {
					this.test = "?";
				} else {
					this.test = testParts[testParts.length - 1];
				}
			}
			break;
		case "method.name":
			this.currentTestMethod = value;
			break;
		case "method.total":
			try {
				this.totalTestMethods = Integer.parseInt(value);
			} catch(Exception e) {
				this.totalTestMethods = -2;
			}
			break;
		case "method.current":
			try {
				this.actualTestMethod = Integer.parseInt(value);
			} catch(Exception e) {
				this.actualTestMethod = -2;
			}
			break;
		}

		if (type != Type.DELETE) {
			this.lastPropertyModification = Instant.now();
		}

		return;
	}

	public synchronized boolean isValid() {
		if (this.status != null) {
			return true;
		}

		return false;
	}

	public synchronized boolean updatedRecently() {
		Instant fiveSecondsAgo = Instant.now().minusSeconds(5);
		if (lastPropertyModification.compareTo(fiveSecondsAgo) >= 0) {
			return true;
		}
		return false;
	}

	public String getRunName() {
		return this.runName;
	}

	public Instant getQueued() {
		return this.queued;
	}

}
